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
 * Класс, для работы с окном студентов
 */
public class StudentsController {

    @FXML
    private TextField nameInput;

    @FXML
    private TextField specInput;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    /**
     * Метод, добавления студентов в БД
     */
    public void addData(){
        addButton.setOnAction(event -> {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Students.class)
                    .addAnnotatedClass(Commission.class)
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
            Students students = new Students();
            students.setName(nameInput.getText());
            System.out.println(students);
            session.save(students);
            System.out.println(students);
            tx.commit();
            session.close();
        });
    }

    /**
     * Метод для удаления студентов из БД
     */
    public void deleteData(){
        deleteButton.setOnAction(event -> {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Students.class)
                    .addAnnotatedClass(Commission.class)
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
            Students students = new Students();
            System.out.println(students);
            students.getName();
            session.delete(students);
            System.out.println(students);
            tx.commit();
            session.close();
        });
    }
}