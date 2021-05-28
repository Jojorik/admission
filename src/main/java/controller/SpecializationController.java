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
 * Класс, для работы с окном специальностей
 */
public class SpecializationController {
    @FXML
    private TextField nameInput;
    @FXML
    private TextField formInput;
    @FXML
    private TextField scoreInput;
    @FXML
    private Button addButton;

    /**
     * Метод, для добаления специальности
     */
    public void addDataSpecialize(){
        addButton.setOnAction(event -> {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Specialization.class)
                    .addAnnotatedClass(Students.class)
                    .addAnnotatedClass(Commission.class)
                    .addAnnotatedClass(Entrant.class)
                    .addAnnotatedClass(Representative.class);

            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
            Session session = sessionFactory.getCurrentSession();
            System.out.println(session);
            Transaction tx = session.beginTransaction();
            Specialization specialization = new Specialization();
            System.out.println(specialization);
            specialization.setName(nameInput.getText());
            specialization.setForm(formInput.getText());
            specialization.setScore(Double.parseDouble(scoreInput.getText()));
            session.save(specialization);
            System.out.println(specialization);
            tx.commit();
            session.close();
        });
    }

}
