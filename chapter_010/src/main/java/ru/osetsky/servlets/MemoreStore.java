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
    private final  SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();

    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void add(Item item) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Item> getAll() {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Item> itemList = session.createQuery("from Item").list();
        session.getTransaction().commit();
        session.close();
        return itemList;
    }

}