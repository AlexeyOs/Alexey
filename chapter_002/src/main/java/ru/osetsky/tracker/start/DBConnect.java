package ru.osetsky.tracker.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sqlite.JDBC;
import ru.osetsky.tracker.models.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by koldy on 14.04.2018.
 */
public class DBConnect {
    /*
     * Поле необходимое для подключения к базе данных.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DBConnect.class);
    /*
     * Константа, в которой хранится адрес подключения.
     */
    private static final String URL = "jdbc:sqlite:C:/projects/Alexey/chapter_002/src/main/java/ru/osetsky/tracker/mytracker.db";
    /*
     * Объект, в котором будет храниться соединение с БД.
     */
    private Connection connection;
    /*
     * Подключение к базе и создание первой таблицы.
     */
    public DBConnect() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(URL);
        connection.setAutoCommit(false);
        Statement stmt = null;
        try {
            // создание таблицы в базе данных
            stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS TRACKER (id INTEGER not NULL,"
                    + "NAME VARCHAR ,"
                    + "DESCRIPTION VARCHAR )";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /*
     * Получение данных из таблицы.
     */
    public List<Item> getAllItems() {
        try (Statement statement = this.connection.createStatement()) {
            List<Item> arr = new ArrayList<Item>();
            ResultSet resultSet = statement.executeQuery("select id,name,description from TRACKER");
            while (resultSet.next()) {
                arr.add(new Item(resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getLong("id")));
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    /*
     * Добавление записей в таблицу.
     */
    public void addIntoTable(Item item) {
        try {
            //вставка
            PreparedStatement st = connection.prepareStatement("INSERT INTO TRACKER(id,name,description) values(?, ?, ?)");
            st.setLong(1, Long.parseLong(item.getId()));
            st.setString(2, item.getName());
            st.setString(3, item.getDescription());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateItem(Item item) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE TRACKER "
                + "SET NAME = " + "'" + item.getName() + "',"
                + "description = " + "'" + item.getDescription() + "'"
                + "WHERE id = " + item.getCreate());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Item findItem(long id) {
        try (Statement statement = this.connection.createStatement()) {
            Item arr = new Item();
            ResultSet resultSet = statement.executeQuery("select id,name,description from TRACKER where id = " + id);
            while (resultSet.next()) {
                arr = new Item(resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getLong("id"));
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
            return (Item) Collections.emptyList();
        }
    }
    public Item findByName(String name) {
        try (Statement statement = this.connection.createStatement()) {
            Item arr = new Item();
            ResultSet resultSet = statement.executeQuery("select id,name,description from TRACKER where name = "
                    + "'" + name + "'");
            while (resultSet.next()) {
                arr = new Item(resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getLong("id"));
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
            return (Item) Collections.emptyList();
        }
    }
    /*
     * Так как Autocommit = false, то commit делается вызовом данного метода.
     */
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * Удаление данных из таблицы.
     */
    public void deleteTable(long id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM TRACKER WHERE id = ?")) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
