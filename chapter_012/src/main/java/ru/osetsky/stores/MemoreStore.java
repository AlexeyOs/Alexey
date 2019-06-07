package ru.osetsky.stores;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.osetsky.models.Car;
import ru.osetsky.models.Role;
import ru.osetsky.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by koldy on 17.01.2019.
 */
public class MemoreStore implements CarStore<Car>, UserStore<User>, RoleStore<Role> {
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
    public void addCar(Car car) {
        this.tx(session -> session.save(car));
    }

    @Override
    public void editCar(Car car) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(car);
        session.close();
    }

    @Override
    public void deleteCar(Car car) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(car);
        session.close();
    }

    @Override
    public List<Car> getAllCars() {
        return this.tx(session -> session.createQuery("from Car").list());
    }


    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void addUser(User user) {
        this.tx(session -> session.save(user));
    }

    @Override
    public void editUser(User user) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(user);
        session.close();
    }

    @Override
    public void deleteUser(User user) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        return this.tx(session -> session.createQuery("from User").list());
    }

    @Override
    public void addRole(Role role) {
        this.tx(session -> session.save(role));
    }

    @Override
    public void editRole(Role role) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(role);
        session.close();
    }

    @Override
    public void deleteRole(Role role) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(role);
        session.close();
    }

    @Override
    public List<Role> getAllRoles() {
        return this.tx(session -> session.createQuery("from Role").list());
    }


    /**
     * Проверяет наличие администраторской роли у пользователи, чтобы предоставить доступ к редаутированию всех пользователей.
     * @return boolean параметр.
     */
    public boolean checkAdminRoles() {
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement("select u.name, u.login, u.email, u.password from USERS u, ROLES r where r.name = 'admin'")) {
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                if (resultSet.getString("name") != null) {
//                    return true;
//                }
//            }
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return false;
    }

    public List<Car> findCarsByMark(String brand) {
        List<Car> result = new ArrayList<>();
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from Car as c where c.brand = :brand");
            query.setParameter("brand", brand);
            result = query.list();
        }
        return result;
    }


    public List<Car> getImageNotNull() {
        List<Car> result = new ArrayList<>();
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from Car as c where c.base64Image is not null");
            result = query.list();
        }
        return result;
    }

    public List<Car> getImageNull() {
        List<Car> result = new ArrayList<>();
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from Car as c where c.base64Image is null");
            result = query.list();
        }
        return result;
    }

}