package ru.osetsky.httpprotocol;


import org.apache.commons.dbcp2.BasicDataSource;
import ru.osetsky.models.Role;
import ru.osetsky.models.User;

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

    public static BasicDataSource getDataSource() {
        if (dataSource == null) {
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

    private DBStore() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Драйвер не загружен");
        }
        try {
            BasicDataSource dataSource = DBStore.getDataSource();
            Connection connection = dataSource.getConnection();
            PreparedStatement psTableRoles = connection.prepareStatement("CREATE TABLE IF NOT EXISTS roles ("
            + "id serial,"
            + "name varchar NOT NULL,"
            + "description text NOT NULL,"
            + "addcontent boolean default FALSE,"
            + "updatecontent boolean default FALSE,"
            + "seealluser boolean default FALSE,"
            + "PRIMARY KEY (id))");
            psTableRoles.execute();
            psTableRoles.close();
            PreparedStatement psTableUsers = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id SERIAL,"
                    + "NAME VARCHAR ,"
                    + "LOGIN VARCHAR,"
                    + "EMAIL VARCHAR,"
                    + "PASSWORD VARCHAR,"
                    + "ROLE INTEGER REFERENCES roles(id),"
                    + "createDate VARCHAR,"
                    + "country VARCHAR,"
                    + "city VARCHAR)");
            psTableUsers.execute();
            psTableUsers.close();
            boolean insertAdmin = true;
            PreparedStatement psSelectCheckAdmin = connection.prepareStatement("SELECT NAME FROM ROLES WHERE ID = 1");
            ResultSet resultSet = psSelectCheckAdmin.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString("name").equals("admin")) {
                    insertAdmin = false;
                }
            }
            psSelectCheckAdmin.close();
            if (insertAdmin) {
                PreparedStatement psInsertAdmin = connection.prepareStatement("insert into roles (id, name, description, addcontent, updatecontent,seealluser)"
                        + "    values (1,'admin', 'administrator', true, true, true); "
                        + "insert into roles (id, name, description, addcontent, updatecontent,seealluser)"
                        + "    values (2,'user', 'user', FALSE , true, FALSE ); "
                        + "insert into users (name, login, email, password, role, createDate)"
                        + "values ('admin', 'admin', 'alexeyosetsky@gmail.com', '1234', 1, '23.06.2018');");
                psInsertAdmin.execute();
                psInsertAdmin.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void add(String name,  String login, String email,
                    String password, int role, String createDate,
                    String country, String city) {
        try {
            //вставка
            Connection connection = dataSource.getConnection();
            PreparedStatement st = connection.prepareStatement("INSERT INTO users(name,"
                    + " login, email, password, role, createDate) values(?, ?, ?, ?, ?, ?)");
            st.setString(1, name);
            st.setString(2, login);
            st.setString(3, email);
            st.setString(4, password);
            st.setInt(5, role);
            st.setString(6, createDate);
            st.execute();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, String name, String login,
                       String email, String password, String createDate,
                       String country, String city) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(
                "UPDATE users SET "
                        + " name = ?,"
                        + " login = ?,"
                        + " email = ?,"
                        + " password = ?,"
                        + " createDate = ?,"
                        + " country = ?,"
                        + " city = ?"
                        + "WHERE id = ?")) {
            st.setString(1, name);
            st.setString(2, login);
            st.setString(3, email);
            st.setString(4, password);
            st.setString(5, createDate);
            st.setString(6, country);
            st.setString(7, createDate);
            st.setInt(8, Integer.parseInt(id));
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
                "DELETE FROM users WHERE id = ?")) {
            statement.setInt(1, Integer.parseInt(id));
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement st = connection.prepareStatement(
                    "select id, name, login, email, password, role, createDate, country, city from users");
            List<User> arr = new ArrayList<>();
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                arr.add(new User(resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("role"),
                        resultSet.getString("createDate"),
                        resultSet.getString("country"),
                        resultSet.getString("city")));
            }
            st.close();
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public User findBy(String id) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select name, login, email, password, role, createDate, country, city from USERS where id =" + id)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(id,
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("role"),
                        resultSet.getString("createDate"),
                        resultSet.getString("country"),
                        resultSet.getString("city"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addRole(String name, String description, boolean addcontent, boolean updatecontent, boolean seealluser) {
        try {
            //вставка
            Connection connection = dataSource.getConnection();
            PreparedStatement st = connection.prepareStatement("INSERT INTO roles(name, description, addcontent, updatecontent, seealluser) values(?, ?, ?, ?, ?)");
            st.setString(1, name);
            st.setString(2, description);
            st.setBoolean(3, addcontent);
            st.setBoolean(4, updatecontent);
            st.setBoolean(5, seealluser);
            st.execute();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRole(String id, String name, String description, boolean addcontent, boolean updatecontent, boolean seealluser) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(
                     "UPDATE roles SET "
                             + " name = ?,"
                             + " description = ?,"
                             + " addcontent = ?,"
                             + " updatecontent = ?,"
                             + " seealluser = ?"
                             + "WHERE id = ?")) {
            st.setString(1, name);
            st.setString(2, description);
            st.setBoolean(3, addcontent);
            st.setBoolean(4, updatecontent);
            st.setBoolean(5, seealluser);
            st.setInt(6, Integer.parseInt(id));
            st.execute();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRole(String id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM roles WHERE id = ?")) {
            statement.setInt(1, Integer.parseInt(id));
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> findAllRoles() {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement st = connection.prepareStatement(
                    "select id,name, description, addcontent, updatecontent, seealluser from roles");
            List<Role> arr = new ArrayList<>();
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                arr.add(new Role(resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("addcontent"),
                        resultSet.getBoolean("updatecontent"),
                        resultSet.getBoolean("seealluser")));
            }
            st.close();
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Role findByRole(String id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT name, description, addcontent, updatecontent, seealluser from roles where id =" + id)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Role(id,
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("addcontent"),
                        resultSet.getBoolean("updatecontent"),
                        resultSet.getBoolean("seealluser"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Проверяет наличие администраторской роли у пользователи, чтобы предоставить доступ к редаутированию всех пользователей.
     * @return boolean параметр.
     */
    public boolean checkAdminRoles() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select u.name, u.login, u.email, u.password from USERS u, ROLES r where r.name = 'admin'")) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               if (resultSet.getString("name") != null) {
                   return true;
               }
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}