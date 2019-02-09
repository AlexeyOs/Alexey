package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.osetsky.models.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Слой Logic, который между Servlet и DB, Memory.
 */
public class ValidateService implements Store<Car> {
    private static final Logger LOG = LoggerFactory.getLogger(ItemAdd.class);
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

    public String addStr(Car car) {
        String greetings = "";
//        try {
//            logic.add(item);
//            greetings ="<tr><td>" + item.getDesc() + "</td><td>" + item.getCreated() + "</td><td>" + item.getDone() + "</td></tr>";
//        } catch (Exception e) {
//            LOG.error(String.valueOf(e));
//        }
        return greetings;
    }

    /**
     *
     * Получение данных из таблицы.
     */
    @Override
    public List<Car>  getAll() {
        return logic.getAll();
    }

    public String getAllStr() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Car> items = new ArrayList<>();
        items = logic.getAll();
//        for (Item item : items){
//            stringBuilder.append("<tr><td>");
//            stringBuilder.append(item.getDesc());
//            stringBuilder.append("</td><td>");
//            stringBuilder.append(item.getCreated());
//            stringBuilder.append("</td><td>");
//            if (item.getDone()) {
//                stringBuilder.append("<input type=\"checkbox\" id=\"" + item.getId() + "\" checked onchange=\"taskReady(id)\">");
//            } else {
//                stringBuilder.append("<input type=\"checkbox\" id=\"" + item.getId() + "\" onchange=\"taskReady(id)\">");
//            }
//            stringBuilder.append("</td></tr>");
//        }
        return stringBuilder.toString();
    }
}
