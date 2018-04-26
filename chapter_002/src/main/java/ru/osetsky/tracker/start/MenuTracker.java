package ru.osetsky.tracker.start;

import ru.osetsky.tracker.models.Item;
import ru.osetsky.tracker.templates.BaseAction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koldy on 16.06.2017.
 */
public class MenuTracker {
	/**
     * Поле для ввода параметров в меню.
     */
    private Input input;
	/**
     * Поле для манипуляций с данными.
     */
    private Tracker tracker;
    /**
     * Поля позиции компонентов в меню.
     */
    private int position = 0;
	/**
     * Конструктор меню.
	 * @param input данные о выборе пункта меню.
	 * @param tracker объект для манипулирования с данными.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод хранящий пункты меню.
     */
    private List<UserAction> actions = new ArrayList();
	/**
     * Метод активирующий меню.
     */
    public void fillActions() {
        this.actions.add(position++, new AddItem(0, "Add"));
        this.actions.add(position++, new ShowItems(1, "Show"));
        this.actions.add(position++, new EditItem(2, "Edit"));
        this.actions.add(position++, new DeleteItem(3, "Delete"));
        this.actions.add(position++, new FindItemById(4, "FindId"));
        this.actions.add(position++, new FindItemByName(5, "FindName"));
    }
	/**
     * Метод для выбора меню.
	 * @param key введенный ключ определяют выбранный пункт меню.
     */
    public void select(int key) throws SQLException {
        for (UserAction u : actions) {
            if (u.key() == key) {
                u.execute(this.input, this.tracker);
            }
        }
    }
	/**
     * Метод выводящий пункты меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
	/**
     * Класс вызывающий методы, добавляющие данные в базу.
     */
    public class AddItem extends BaseAction {
        /**
         *
         * @param key ключ меню
         * @param name Имя меню.
         */
        AddItem(int key, String name) {
            super(key, name);
        }
        /**
		 * Метод выполняет вывод вопросов и считывает введенные данные, после чего отправляет на запись.
		 * @param input Входные данные
		 * @param tracker отправка на запись в базу.
		 */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the tak's name: ");
            Item itemStartUi = new Item();
            itemStartUi.setName(name);
            String description = input.ask("Please, enter description");
            itemStartUi.setDescription(description);
            tracker.add(itemStartUi);
        }
		/**
		 * Метод выводит название данного пункта меню.
		 * @return String.
		 */
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }
	/**
     * Класс, который обрабатывает пункт меню отвечающий за вывод всех заявок.
     */
    private static class ShowItems extends BaseAction {
        /**
         * @param key ключ меню
         * @param name имя меню.
         */
        private ShowItems(int key, String name) {
            super(key, name);
        }
		/**
		 * Метод, который представляет из себя пукнт управления данным пунктом меню.
		 * @param input Входные данные
		 * @param tracker отправка запроса в базу.
		 */
        public void execute(Input input, Tracker tracker) {
           for (Item item: tracker.getAll()) {
               System.out.println(String.format("%s. %s", item.getCreate(), item.getName()));
           }
        }
		/**
		 * Метод выводит название данного пункта меню.
		 * @return String.
		 */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }
	/**
     * Класс отвечает за редактирование !!!первой записи.
     */
    private static class EditItem extends BaseAction {
        /**
         * @param key ключ меню
         * @param name имя меню.
         */
        private EditItem(int key, String name) {
            super(key, name);
        }
		/**
		 * Метод управляющий редактированием !!!первой!!! записи.
         * @param input Входные данные
         * @param tracker отправка запроса в базу.
		 */
        public void execute(Input input, Tracker tracker) {
            //изменяет первый элемент
            List<Item> itemAR1 = new ArrayList<Item>();
            itemAR1 = tracker.getAll();
            Long oldid = null;
            for (Item item: itemAR1) {
                if (item != null) {
                    oldid = item.getCreate();
                    break;
                }
            }
            String name = input.ask("Please, enter tak's name: ");
            Item itemStartUi = new Item();     //создал новый item
            itemStartUi.setName(name);
            String description = input.ask("Please, enter description");
            itemStartUi.setDescription(description);
            itemStartUi.setCreate(oldid);         //привязал тот же id
            tracker.update(itemStartUi);      //вызвал метод update
            for (Item item : tracker.getAll()) {
                System.out.println(item.getName());
            }
        }
		/**
		 * Метод выводит название данного пункта меню.
		 * @return String.
		 */
        public String info() {
			return String.format("%s. %s", this.key(), "Edit item");
		}
    }
	/**
     * Класс отвечает за удаление !!!первой записи.
     */
    public static class DeleteItem extends BaseAction {
        /**
         * @param key ключ меню
         * @param name имя меню.
         */
        public DeleteItem(int key, String name) {
            super(key, name);
        }
		/**
		 * Метод управляющие удаление !!!первой записи.
         * @param input Входные данные
         * @param tracker отправка запроса в базу.
		 */
        public void execute(Input input, Tracker tracker) {
            //удаляет первый элемент
            List<Item> itemAR1 = new ArrayList<Item>();
            itemAR1 = tracker.getAll();
            // взял старый id первого объекта
            Long oldid = null;
            for (Item item: itemAR1) {
                if (item != null) {
                    oldid = item.getCreate();
                    break;
                }
            }
            Item itemDel = new Item();         //создал новый элемент
            itemDel.setCreate(oldid);
            tracker.delete(itemDel);
            for (Item item : tracker.getAll()) {
                System.out.println(item.getName());
            }
        }
		/**
		 * Метод выводит название данного пункта меню.
		 * @return String.
		 */
        public String info() {
			return String.format("%s. %s", this.key(), "Delete item");
		}
    }
	/**
     * Класс отвечающий за поиск записи по id.
     */
    public static class FindItemById extends BaseAction {
        /**
         * @param key ключ меню
         * @param name имя меню.
         */
        public FindItemById(int key, String name) {
            super(key, name);
        }
		/**
		 * Метод управляющий поиском записи.
         * @param input Входные данные
         * @param tracker отправка запроса в базу.
		 */
        public void execute(Input input, Tracker tracker) {

            for (Item item : tracker.getAll()) {
                System.out.println(item.getCreate());
            }
            Item item = new Item();
            String id = input.ask("Please, enter the tak's id: ");
            item = tracker.findById(id);
            System.out.println(item.getName());
            System.out.println(item.getDescription());

        }
		/**
		 * Метод выводит название данного пункта меню.
		 * @return String.
		 */
        public String info() {
			return String.format("%s. %s", this.key(), "Find item by Id");
		}
    }
	/**
     * Класс отвечающий за поиск записи по именю.
     */
    public static class FindItemByName extends BaseAction {
        /**
         * @param key ключ меню
         * @param name имя меню.
         */
        public FindItemByName(int key, String name) {
            super(key, name);
        }
		/**
		 * Метод управляющий поиском записи.
         * @param input Входные данные
         * @param tracker отправка запроса в базу.
		 */
        public void execute(Input input, Tracker tracker) {
            Item item = new Item();
            String name = input.ask("Please, enter the tak's name: ");
            item = tracker.findByName(name);
            System.out.println(item.getName());
            System.out.println(item.getDescription());
        }
		/**
		 * Метод выводит название данного пункта меню.
		 * @return String.
		 */
        public String info() {
			return String.format("%s. %s", this.key(), "Find items by name");
		}
    }
}
