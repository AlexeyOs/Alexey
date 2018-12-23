package ru.osetsky.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.osetsky.models.User;


public class UserStorage {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setLogin("test");
        session.save(user);
//        try {
//            System.out.println(session.createQuery("from User").list());
//        } catch (Exception e){
//            System.out.println(e);
//        }
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
