package osetsky.httpprotocol;

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





}
