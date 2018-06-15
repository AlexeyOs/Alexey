package osetsky.httpprotocol;


import org.apache.commons.dbcp2.BasicDataSource;
import osetsky.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by koldy on 27.05.2018.
 */
public class DBStore implements Store {
    private static BasicDataSource dataSource;
    private static final DBStore INSTANCE = new DBStore();
    public static DBStore getInstance() {
        return INSTANCE;
    }

    public static BasicDataSource getDataSource()
    {
        if (dataSource == null)
        {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl("jdbc:postgresql://localhost:5432/java_a_from_z");
            ds.setUsername("postgres");
            ds.setPassword("1234");
            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);
            dataSource = ds;
        }
        return dataSource;
    }

    private DBStore()
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Драйвер не загружен");
        }
        try {
            BasicDataSource dataSource = DBStore.getDataSource();
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE IF NOT EXISTS SERVLET (id SERIAL,"
                    + "NAME VARCHAR ,"
                    + "LOGIN VARCHAR,"
                    + "EMAIL VARCHAR,"
                    + "PASSWORD VARCHAR,"
                    + "createDate VARCHAR)");
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> findAll() {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement st = connection.prepareStatement(
                "select id,name,login, email, password, createDate from SERVLET");
            List<User> arr = new ArrayList<>();
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()){
                arr.add(new User(resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("createDate")));
            }
            st.close();
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void add(String name,  String login, String email, String password, String createDate) {
        try {
            //вставка
            Connection connection = dataSource.getConnection();
            PreparedStatement st = connection.prepareStatement("INSERT INTO SERVLET(name, login, email, password, createDate) values(?, ?, ?, ?, ?)");
            st.setString(1, name);
            st.setString(2, login);
            st.setString(3, email);
            st.setString(4, password);
            st.setString(5, createDate);
            st.execute();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, String name, String login, String email, String password, String createDate) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(
                "UPDATE SERVLET SET "
                        + " name = ?,"
                        + " login = ?,"
                        + " email = ?,"
                        + " password = ?,"
                        + " createDate = ?"
                        + "WHERE id = ?")) {
            st.setString(1, name);
            st.setString(2, login);
            st.setString(3, email);
            st.setString(4, password);
            st.setString(5, createDate);
            st.setInt(6, Integer.parseInt(id));
            st.execute();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM SERVLET WHERE id = ?")) {
            statement.setInt(1, Integer.parseInt(id));
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findBy(String id) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select name, login, email, password, createDate from SERVLET where id =" + id)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(id,
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("createDate"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}