package ru.osetsky.parcer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sqlite.JDBC;
import ru.osetsky.jdbc.SQLStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by koldy on 25.04.2018.
 */
public class DbConnect {
    /*
  * Поле необходимое для подключения к базе данных.
  */
    private static final Logger LOG = LoggerFactory.getLogger(SQLStorage.class);
    /*
     * Константа, в которой хранится адрес подключения.
     */
    private static final String URL = "jdbc:sqlite:C:/projects/Alexey/chapter_008/src/main/java/ru/osetsky/parcer/parcer.db";
    /*
     * Объект, в котором будет храниться соединение с БД.
     */
    private Connection connection;

    /*
     * Подключение к базе и создание первой таблицы.
     */
    public DbConnect() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(URL);
        connection.setAutoCommit(false);
        Statement stmt = null;
        try {
            // создание таблицы в базе данных
            stmt = connection.createStatement();
            //!!! Сделать autoincrement id.
            String sql = "CREATE TABLE IF NOT EXISTS PARCE (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "NAME VARCHAR ,"
                    + "HREF VARCHAR)";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /*
     * Получение данных из таблицы.
     */
    public List<Vacancy> getAllItems() {
        try (Statement statement = this.connection.createStatement()) {
            List<Vacancy> arr = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select id,name,href from PARCE");
            while (resultSet.next()) {
                arr.add(new Vacancy(resultSet.getString("name"),
                        resultSet.getString("href")));
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
    public void addIntoTable(String name, String href) {
        try {
            //вставка
                PreparedStatement st = connection.prepareStatement("INSERT INTO PARCE(name, href) values(?,?)");
                st.setString(1, name);
                st.setString(2, href);
                st.executeUpdate();
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
                "DELETE FROM PARCE")) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
