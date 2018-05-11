package osetsky.jsp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Created by koldy on 06.05.2018.
 */
public class UserStorage {
    private static final Logger LOG = LoggerFactory.getLogger(UserStorage.class);
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_a_from_z";
    private static final String USER = "postgres";
    private static final String PASS = "1234";
    private Connection connection;
    private static final UserStorage INSTANCE = new UserStorage();
    private UserStorage() {
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

    public static UserStorage getInstance() {
        return INSTANCE;
    }

    public List<User> getUsers() {
        try (Statement statement = this.connection.createStatement()) {
            List<User> arrUsers = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select id,name,login, email, createDate from SERVLET");
            while (resultSet.next()) {
                arrUsers.add(new User(resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getString("createDate")));
            }
            return arrUsers;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    /**
     * Добавление записей в таблицу.
     */
    public void addIntoTable(User user) {
        try {
            //вставка
            PreparedStatement st = connection.prepareStatement("INSERT INTO SERVLET(name, login, email, createDate) values(?, ?, ?, ?)");
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setString(4, user.getCreateDate());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
}
