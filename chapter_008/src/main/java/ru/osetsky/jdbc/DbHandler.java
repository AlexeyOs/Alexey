package ru.osetsky.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

public class DbHandler {
    /*
     * Поле необходимое для подключения к базе данных.
     */
    private static final Logger LOG = LoggerFactory.getLogger(SQLStorage.class);
    /*
     * Константа, в которой хранится адрес подключения.
     */
    private static final String URL = "jdbc:sqlite:C:/projects/Alexey/chapter_008/src/main/java/ru/osetsky/jdbc/myfin.db";
    /*
     * Объект, в котором будет храниться соединение с БД.
     */
    private Connection connection;

    /*
     * Подключение к базе и создание первой таблицы.
     */
    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(URL);
        connection.setAutoCommit(false);
        Statement stmt = null;
        try {
            // создание таблицы в базе данных
            stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS TEST (field INTEGER not NULL)";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /*
     * Получение данных из таблицы.
     */
    public List<Integer> getAllItems() {
        try (Statement statement = this.connection.createStatement()) {
            List<Integer> arr = new ArrayList<Integer>();
            ResultSet resultSet = statement.executeQuery("select field from TEST");
            while (resultSet.next()) {
                arr.add(new Integer(resultSet.getInt("field")));
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
    public void addIntoTable(int countElemnts) {
        try {
            //вставка
            for (int i = 0; i < countElemnts; i++) {
                PreparedStatement st = connection.prepareStatement("INSERT INTO test(field) values(?)");
                st.setInt(1, i);
                st.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
    public void deleteTable() {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM TEST")) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}