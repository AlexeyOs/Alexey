package osetsky.httpprotocol;

import java.util.ArrayList;
import java.util.List;

/**
 * Слой Logic, который между Servlet и DB, Memory.
 */
public class ValidateService implements Store{
//    private final MemoryStore logic = MemoryStore.getInstance();
    private final DBStore logic = DBStore.getInstance();
    private static final ValidateService INSTANCE = new ValidateService();
    public static ValidateService getInstance() {
        return INSTANCE;
    }
    /**
     * Добавление записей в таблицу.
     */
    @Override
    public void add(String name, String login, String email, String createDate) {
        //проверяет есть ли такой пользователь в базе, если пользователь уникальный, то добавляет нового.
        boolean repeat = false;
        User newuser = new User(name, login, email, createDate);
        List<User> listUsers = logic.findAll();
        for (User user:listUsers) {
            if (user.equals(newuser)){
                repeat = true;
            }
        }
        if(!repeat){
            logic.add(name, login, email, createDate);
//            logic.commit();
        }
    }

    /**
     *
     * Изменение данных из таблицы.
     */
    @Override
    public void update(String id, String name, String login, String email, String createDate) {
        //проверяет есть ли такой id в базе, если есть, то обновляет пользователя
        if (logic.findBy(id) != null) {
            logic.update(id, name, login, email, createDate);
//            logic.commit();
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
//            logic.commit();
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
}
