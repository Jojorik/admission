import Entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Класс, для старта программы
 */
public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class);

        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
        Session session = sessionFactory.getCurrentSession();
        System.out.println(session);
        Transaction tx = session.beginTransaction();
        Users user = new Users();
        user.setId(2);
        user.setName("Леонид");
        System.out.println(user);
        session.save(user);
        System.out.println(user);
        tx.commit();
        session.close();

    }
}
