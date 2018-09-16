package osetsky.httpprotocol;

import osetsky.models.Role;
import osetsky.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Слой Logic, который между Servlet и DB, Memory.
 */
public class ValidateService implements Store {
    private final DBStore logic = DBStore.getInstance();
    private static final ValidateService INSTANCE = new ValidateService();
    public static ValidateService getInstance() {
        return INSTANCE;
    }

    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void add(String name, String login, String email, String password,
                    int role, String createDate, String country, String city) {
        //проверяет есть ли такой пользователь в базе, если пользователь уникальный, то добавляет нового.
        boolean repeat = false;
        User newuser = new User(name, login, email, password, role, createDate, country, city);
        List<User> listUsers = logic.findAll();
        for (User user:listUsers) {
            if (user.equals(newuser)) {
                repeat = true;
            }
        }
        if (!repeat) {
            logic.add(name, login, email, password, role, createDate, country, city);
        }
    }

    /**
     *
     * Изменение данных из таблицы.
     */
    @Override
    public void update(String id, String name, String login,
                       String email, String password, String createDate,
                       String country, String city) {
        //проверяет есть ли такой id в базе, если есть, то обновляет пользователя
        if (logic.findBy(id) != null) {
            logic.update(id, name, login, email, password, createDate, country, city);
        }
    }

    /**
     *
     * Удаление данных из таблицы.
     */
    @Override
    public void delete(String id) {
        if (logic.findBy(id) != null) {
            logic.delete(id);
        }
    }
    /**
     *
     * Получение данных из таблицы.
     */
    @Override
    public List<User>  findAll() {
        return logic.findAll();
    }

    /**
     * Получение данных в преобразованном виде.
     * @return массив пользователей в формате строк.
     */
    public List<List<String>> findAllStr() {
        List<User> listUsers = logic.findAll();
        List<List<String>> list = new ArrayList<>();
        List<String> lst = new ArrayList<>();
        for (User user:listUsers) {
            lst.add(user.getId());
            lst.add(user.getName());
            lst.add(user.getLogin());
            lst.add(user.getEmail());
            lst.add(user.getCreateDate());
            list.add(lst);
            lst = new ArrayList<>();
        }
        return list;
    }

    @Override
    public User findBy(String id) {
       return logic.findBy(id);
    }

    @Override
    public void addRole(String name, String description, boolean addcontent, boolean updatecontent, boolean seealluser) {
        logic.addRole(name, description, addcontent, updatecontent, seealluser);
    }

    @Override
    public void updateRole(String id, String name, String description, boolean addcontent, boolean updatecontent, boolean seealluser) {
        if (logic.findByRole(id) != null) {
            logic.updateRole(id, name, description, addcontent, updatecontent, seealluser);
        }
    }

    @Override
    public void deleteRole(String id) {
        if (logic.findByRole(id) != null) {
            logic.deleteRole(id);
        }
    }

    @Override
    public List<Role> findAllRoles() {
        return logic.findAllRoles();
    }

    @Override
    public Role findByRole(String id) {
        return logic.findByRole(id);
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

    /**
     * Проверка наличия пользователя.
     */
    public boolean isCredentional(String login, String password) {
        boolean exists = false;
        List<User> users = logic.findAll();
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
}
