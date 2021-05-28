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
 * Класс, для работы с окном абитуриентов
 */


public class EntrantController {

    @FXML
    private TextField nameInput;

    @FXML
    private TextField scoreInput;

    @FXML
    private TextField idpasportInput;

    @FXML
    private TextField passportSeriesInput;

    @FXML
    private TextField sexInput;

    @FXML
    private TextField registrationInput;

    @FXML
    private TextField citizenshipInput;

    @FXML
    private Button addButton;

    /**
     * Метод, для добавления абитуриента в БД
     */
    public void addDataEntrent(){
        addButton.setOnAction(event -> {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Entrant.class)
                    .addAnnotatedClass(Students.class)
                    .addAnnotatedClass(Specialization.class)
                    .addAnnotatedClass(Commission.class)
                    .addAnnotatedClass(Representative.class);

            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
            Session session = sessionFactory.getCurrentSession();
            System.out.println(session);
            Transaction tx = session.beginTransaction();
            Entrant entrant = new Entrant();
            System.out.println(entrant);
            entrant.setName(nameInput.getText());
            entrant.setScore(Float.parseFloat(scoreInput.getText()));
            entrant.setPassportId(Integer.parseInt(idpasportInput.getText()));
            entrant.setPassportSeries(Integer.parseInt(passportSeriesInput.getText()));
            entrant.setGender(sexInput.getText());
            entrant.setRegistration(registrationInput.getText());
            entrant.setCitizenship(citizenshipInput.getText());
            session.save(entrant);
            System.out.println(entrant);
            tx.commit();
            session.close();
        });
    }


}
