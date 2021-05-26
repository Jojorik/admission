package controller;
import Entity.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Класс, для работы с окном представителей
 */
public class RepresentativeController {

        @FXML
        private TextField nameInput;

        @FXML
        private TextField phoneInput;

        @FXML
        private TextField registrationInput;

        @FXML
        private TextField sexInput;

        @FXML
        private TextField citizenInput;

        @FXML
        private TextField parentInput;

        @FXML
        private TextField trusteeInput;

        @FXML
        private Button addButton;

        /**
         * Метод для добавления представителя в БД
         */
        public void addDataRepresentative(){
                addButton.setOnAction(event -> {
                        Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Representative.class)
                                .addAnnotatedClass(Students.class)
                                .addAnnotatedClass(Specialization.class)
                                .addAnnotatedClass(Commission.class)
                                .addAnnotatedClass(Entrant.class);

                        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
                        sb.applySettings(cfg.getProperties());
                        StandardServiceRegistry standardServiceRegistry = sb.build();
                        SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
                        Session session = sessionFactory.getCurrentSession();
                        System.out.println(session);
                        Transaction tx = session.beginTransaction();
                        Representative representative = new Representative();
                        System.out.println(representative);
                        representative.setName(nameInput.getText());
                        representative.setPhoneNumber(Integer.parseInt(phoneInput.getText()));
                        representative.setRegistration(registrationInput.getText());
                        representative.setCitizenship(citizenInput.getText());
                        representative.setGender(sexInput.getText());
                        representative.setParent(parentInput.getText());
                        representative.setTrustee(trusteeInput.getText());
                        session.save(representative);
                        System.out.println(representative);
                        tx.commit();
                        session.close();
                });
        }

}


