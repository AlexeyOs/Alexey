package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.osetsky.models.Car;
import ru.osetsky.models.Role;
import ru.osetsky.models.User;
import ru.osetsky.stores.CarStore;
import ru.osetsky.stores.MemoreStore;
import ru.osetsky.stores.RoleStore;
import ru.osetsky.stores.UserStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Слой Logic, который между Servlet и DB, Memory.
 */
public class ValidateService implements CarStore<Car>, UserStore<User>, RoleStore<Role> {
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
    public void addCar(Car car) {
        logic.addCar(car);
    }

    @Override
    public void editCar(Car car) {
        logic.editCar(car);
    }

    @Override
    public void deleteCar(Car car) {
        logic.editCar(car);
    }

    /**
     *
     * Получение данных из таблицы.
     */
    @Override
    public List<Car>  getAllCars() {
        return logic.getAllCars();
    }


    public Car getCarById(int id) {
        List<Car> cars = new ArrayList<>();
        cars = logic.getAllCars();
        for (Car car : cars) {
            if (car.getId().equals(String.valueOf(id))){
                return car;
            }
        }
        return null;
    }

    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void addUser(User user) {
        logic.addUser(user);
    }

    /**
     *
     * Изменение данных из таблицы.
     */
    @Override
    public void editUser(User user) {
        logic.editUser(user);
    }

    /**
     *
     * Удаление данных из таблицы.
     */
    @Override
    public void deleteUser(User user) {
            logic.deleteUser(user);
    }
    /**
     *
     * Получение данных из таблицы.
     */
    @Override
    public List<User>  getAllUsers() {
        return logic.getAllUsers();
    }


    public User findUserBy(String id) {
        //TODO написать поиск Пользователя, после корректной сборки
        return null;
    }

    @Override
    public void addRole(Role role) {
        logic.addRole(role);
    }

    @Override
    public void editRole(Role role) {
        logic.editRole(role);
    }

    @Override
    public void deleteRole(Role role) {
        logic.deleteRole(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return logic.getAllRoles();
    }


    public Role findRoleBy(String id) {
        //TODO написать поиск Роли, после корректной сборки
        return null;
    }


    /**
     * Находит пользователя по введенному имени и паролю.
     * @return boolean параметр.
     */
    public User findByLoginAndPass(String login, String password) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Проверка наличия пользователя.
     */
    public boolean isCredentional(String login, String password) {
        boolean exists = false;
        List<User> users = logic.getAllUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    /**
     * Проверяет наличие администраторской роли у пользователи, чтобы предоставить доступ к редаутированию всех пользователей.
     * @return boolean параметр.
     */
    public boolean checkAdminRoles() {
        return logic.checkAdminRoles();
    }

    public List<Car> findCarsByMark(String brand) {
        return logic.findCarsByMark(brand);
    }

    public List<Car> checkImage(String image) {
        if (image.equals("With photo")) {
            return logic.getImageNotNull();
        } else {
            return logic.getImageNull();
        }
    }
}
