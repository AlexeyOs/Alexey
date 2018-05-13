package osetsky.jsp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by koldy on 13.05.2018.
 */
public class DBStore {
    private static BasicDataSource dataSource;
    private Connection connection;
    private static final DBStore INSTANCE = new DBStore();
    private PreparedStatement pstmt;
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
             this.connection = dataSource.getConnection();
             pstmt = connection.prepareStatement("CREATE TABLE IF NOT EXISTS SERVLET (id SERIAL,"
                     + "NAME VARCHAR ,"
                     + "LOGIN VARCHAR,"
                     + "EMAIL VARCHAR,"
                     + "createDate VARCHAR)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        try {
            List<User> arrUsers = new ArrayList<>();
            ResultSet resultSet = pstmt.executeQuery("select id,name,login, email, createDate from SERVLET");
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

    public static void main(String[] args) throws SQLException {
        for (User user : DBStore.getInstance().getUsers()) {
            System.out.print(user.getName());
            System.out.print(user.getEmail());
        }
    }

}
