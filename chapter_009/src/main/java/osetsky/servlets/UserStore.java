package osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by koldy on 20.04.2018.
 */
public class UserStore {
    /*
     * Поле необходимое для подключения к базе данных.
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserStore.class);
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_a_from_z";
    private static final String USER = "postgres";
    private static final String PASS = "1234";

    /**
     * Используем шаблон одиночка Eager initialization(Искаженная инициализация).
     */
    private static final UserStore INSTANCE = new UserStore();

    public static UserStore getInstance() {
        return INSTANCE;
    }
    private Connection connection;
    /*
     * Подключение к базе и создание первой таблицы,
     * частный конструктор, чтобы клиентские приложения не использовали конструктор
     */
    private UserStore() {
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
    /**
     * Добавление записей в таблицу.
     */
    public void addIntoTable(String name, String login, String email, String createDate) {
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
     * Получение данных из таблицы.
     */
    public List<String> getAllItems() {
        try (Statement statement = this.connection.createStatement()) {
            List<String> arr = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select id,name,login, email, createDate from SERVLET");
            while (resultSet.next()) {
                arr.add(new String(resultSet.getString("id")));
                arr.add(new String(resultSet.getString("name")));
                arr.add(new String(resultSet.getString("login")));
                arr.add(new String(resultSet.getString("email")));
                arr.add(new String(resultSet.getString("createDate")));
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
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
    /**
     *
     * Удаление данных из таблицы.
     */
    public void deleteTable(String id) {
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
     * Изменение данных из таблицы.
     */
    public void updateTable(String id, String name, String login, String email, String createDate) {
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

}
