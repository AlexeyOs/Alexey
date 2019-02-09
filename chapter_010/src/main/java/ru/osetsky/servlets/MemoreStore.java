package ru.osetsky.servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.osetsky.models.Car;
import ru.osetsky.models.Item;

import java.util.List;
import java.util.function.Function;

/**
 * Created by koldy on 17.01.2019.
 */
public class MemoreStore implements Store<Car> {
    private static final MemoreStore INSTANCE = new MemoreStore();
    public static MemoreStore getInstance() {
        return INSTANCE;
    }
    private final  SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();

    private <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void add(Car item) {
        this.tx(session -> session.save(item));
    }

    @Override
    public void edit(Car item) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(item);
        session.close();
    }

    @Override
    public void delete(Car item) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(item);
        session.close();
    }

    @Override
    public List<Car> getAll() {
        return this.tx(session -> session.createQuery("from Car").list());
    }

}