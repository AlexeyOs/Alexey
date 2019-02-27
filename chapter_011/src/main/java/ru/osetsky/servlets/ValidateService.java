package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.osetsky.models.Car;
import ru.osetsky.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Слой Logic, который между Servlet и DB, Memory.
 */
public class ValidateService implements Store<Car> {
    private static final Logger LOG = LoggerFactory.getLogger(ValidateService.class);
    private final MemoreStore logic = MemoreStore.getInstance();
    private static final ValidateService INSTANCE = new ValidateService();
    public static ValidateService getInstance() {
        return INSTANCE;
    }

    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void add(Car car) {
        logic.add(car);
    }

    @Override
    public void edit(Car car) {
        logic.edit(car);
    }

    @Override
    public void delete(Car car) {
        logic.edit(car);
    }


    /**
     *
     * Получение данных из таблицы.
     */
    @Override
    public List<Car>  getAll() {
        return logic.getAll();
    }


    public Car getById(int id) {
        List<Car> cars = new ArrayList<>();
        cars = logic.getAll();
        for (Car car : cars) {
            if (car.getId().equals(String.valueOf(id))){
                return car;
            }
        }
        return null;
    }

    /**
     * Проверка наличия пользователя.
     */
    public boolean isCredentional(String login, String password) {
        boolean exists = false;
        List<User> users = logic.findAll();
        for (User user : users) {
            if (user.getLogin().contains(login) && user.getPassword().contains(password)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    /**
     *
     * Получение данных из таблицы.
     */
//    @Override
    public List<User>  findAll() {
        return logic.findAll();
    }


    /**
     * Находит пользователя по введенному имени и паролю.
     * @return boolean параметр.
     */
    public User findByLoginAndPass(String login, String password) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}
