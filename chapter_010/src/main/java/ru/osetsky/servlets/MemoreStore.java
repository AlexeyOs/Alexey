package ru.osetsky.servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.osetsky.models.Item;

import java.util.List;

/**
 * Created by koldy on 17.01.2019.
 */
public class MemoreStore implements Store {
    private static final MemoreStore INSTANCE = new MemoreStore();
    public static MemoreStore getInstance() {
        return INSTANCE;
    }

    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void add(Item item) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    @Override
    public List<Item> getAll() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Item> itemList = session.createQuery("from Item").list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return itemList;
    }

}