package osetsky.httpprotocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Persistent layout. DB,Memory.
 */
public class MemoryStore implements Store {
    /*
 * Поле необходимое для подключения к базе данных.
 */
    private static final Logger LOG = LoggerFactory.getLogger(MemoryStore.class);
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_a_from_z";
    private static final String USER = "postgres";
    private static final String PASS = "1234";
    private final MemoryStore users = MemoryStore.getInstance();
    /**
     * Используем шаблон одиночка Eager initialization(Искаженная инициализация).
     */
    private static final MemoryStore INSTANCE = new MemoryStore();
    private Connection connection;
    /*
     * Подключение к базе и создание первой таблицы,
     * частный конструктор, чтобы клиентские приложения не использовали конструктор
     */
    private MemoryStore() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Драйвер не загружен");
        }
        // Выполняем подключение к базе данных
        try {
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Ошибка параметров подключения");
        }
        Statement stmt = null;
        try {
            // создание таблицы в базе данных
            stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS SERVLET (id SERIAL,"
                    + "NAME VARCHAR ,"
                    + "LOGIN VARCHAR,"
                    + "EMAIL VARCHAR,"
                    + "createDate VARCHAR)";
            stmt.executeUpdate(sql);
            connection.commit();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public static MemoryStore getInstance() {
        return INSTANCE;
    }
    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void add(String name, String login, String email, String createDate) {
        try {
            //вставка
            PreparedStatement st = connection.prepareStatement("INSERT INTO SERVLET(name, login, email, createDate) values(?, ?, ?, ?)");
            st.setString(1, name);
            st.setString(2, login);
            st.setString(3, email);
            st.setString(4, createDate);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * Изменение данных из таблицы.
     */
    @Override
    public void update(String id, String name, String login, String email, String createDate) {
        try (PreparedStatement st = this.connection.prepareStatement(
                "UPDATE SERVLET SET "
                        + " name = ?,"
                        + " login = ?,"
                        + " email = ?,"
                        + " createDate = ?"
                        + "WHERE id = ?")) {
            st.setString(1, name);
            st.setString(2, login);
            st.setString(3, email);
            st.setString(4, createDate);
            st.setInt(5, Integer.parseInt(id));
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * Удаление данных из таблицы.
     */
    @Override
    public void delete(String id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM SERVLET WHERE id = ?")) {
            statement.setInt(1, Integer.parseInt(id));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * Получение данных из таблицы.
     */
    @Override
    public List<User> findAll() {
        try (Statement statement = this.connection.createStatement()) {
            List<User> arr = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select id,name,login, email, createDate from SERVLET");
            while (resultSet.next()) {
                arr.add(new User(resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getString("createDate")));
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public User findBy(String id) {
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select name,login, email, createDate from SERVLET where id =" + id);
            resultSet.next();
            return new User(resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getString("createDate"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Так как Autocommit = false, то commit делается вызовом данного метода.
     */
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
