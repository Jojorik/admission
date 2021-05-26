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
 * Класс, для работы с окном приемной комиссии
 */
public class CommissionController {
    @FXML
    private TextField nameInput;
    @FXML
    private TextField enroledInput;
    @FXML
    private Button addButton;

    public void addDataCommission(){
        addButton.setOnAction(event -> {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Commission.class)
                    .addAnnotatedClass(Students.class)
                    .addAnnotatedClass(Specialization.class)
                    .addAnnotatedClass(Entrant.class)
                    .addAnnotatedClass(Representative.class);

            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
            Session session = sessionFactory.getCurrentSession();
            System.out.println(session);
            Transaction tx = session.beginTransaction();
            Commission commission = new Commission();
            commission.setSecretary(nameInput.getText());
            commission.setEnrolled(Boolean.parseBoolean(enroledInput.getText()));
            System.out.println(commission);
            session.save(commission);
            System.out.println(commission);
            tx.commit();
            session.close();
        });
    }

}
