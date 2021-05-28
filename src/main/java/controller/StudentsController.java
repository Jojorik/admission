package controller;
import Entity.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Класс, для работы с окном студентов
 */
public class StudentsController {

    public Label error;
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


            String name = nameInput.getText();
            if(checkName(name)){
                error.setText("");
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

            }else {
                error.setText("Неверный формат данных");
            }



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
            Transaction tx = session.beginTransaction();
            String q = "from students where name = '"+nameInput.getText()+"'";

            List<Students> list = session.createQuery(q).list();
            System.out.println(list);
            if(list.size()==0){
                error.setText("Нет студента с таким именем");
            }
            else {
                error.setText("");
                for (Students student:list) {
                    session.delete(student);

                }
                tx.commit();
            }


            session.close();
        });
    }
    private boolean checkName(String name){
        Pattern regex = Pattern.compile("^[а-яА-Яa-zA-Z]+[ ][а-яА-Яa-zA-Z]+[ ][а-яА-Яa-zA-Z]+$");
        return regex.matcher(name).matches();
    }
}