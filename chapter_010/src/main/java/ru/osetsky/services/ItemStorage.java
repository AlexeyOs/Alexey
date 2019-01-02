package ru.osetsky.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.osetsky.models.Item;

public class ItemStorage {


    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Item item = new Item();
//        item.setId("0");
        item.setDesc("test");
        item.setDone(false);
        session.save(item);
        try {
            System.out.println(session.createQuery("from Item").list());
        } catch (Exception e){
            System.out.println(e);
        }
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
