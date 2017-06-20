package ru.osetsky.tracker.start;

import ru.osetsky.tracker.models.Item;

import static java.lang.Integer.parseInt;

/**
 * Created by koldy on 25.03.2017.
 */
public class StartUi {
    /**
     * Field input.
     */
    private Input input;
    /**
     * Filed tracker.
     */
    private Tracker tracker;

    /**
     * Method StartUi.
     * @param input It is Input.
     * @param tracker It is Tracker.
     */
    public StartUi(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * ADD is constant.
     */
    static final int ADD = 0;
    /**
     * SHOW is constant.
     */
    static final int SHOW = 1;
    /**
     * EDIT is constant.
     */
    static final int EDIT = 2;
    /**
     * DELETE is constant.
     */
    static final int DELETE = 3;
    /**
     * FIND_BY_ID is constant.
     */
    static final int FIND_BY_ID = 4;
    /**
     * FIND_BY_NAME is constant.
     */
    static final int FIND_BY_NAME = 5;
    /**
     * EXIT is constant.
     */
    static final int EXIT = 6;
	/**
     * Method StartUi.
     * @return null .
     */
    public StartUi init() {
        /**
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");

        String comand = input.ask("Select: ");
        int k = 0;
        int c = parseInt(comand);
        while (c != EXIT) {
            if (k != 0) {
                comand = input.ask("Select: ");
                c = parseInt(comand);
            }
            if (c == ADD) {

                String name = input.ask("Please, enter the tak's name: ");
                Item itemStartUi = new Item();
                itemStartUi.setName(name);
                String description = input.ask("Please, enter description");
                itemStartUi.setDescription(description);
                tracker.add(itemStartUi);
                for (Item item : tracker.getAll()) {
                    System.out.println(item.getName());
                }
            }
            if (c == SHOW) {
                for (Item item : tracker.getAll()) {
                    System.out.println("Name = " + item.getName());
                    System.out.println("Descption = " + item.getDescription());
                }
            }
            if (c == EDIT) {                       //изменяет первый элемент
                Item[] itemAr = new Item[100];     //создал массив, чтобы вытащить id-шник объекта
                itemAr = tracker.getAll();
                String oldid = itemAr[0].getId();  //взял старый id первого объекта
                String name = input.ask("Please, enter tak's name: ");
                Item itemStartUi = new Item();     //создал новый item
                itemStartUi.setName(name);
                String description = input.ask("Please, enter description");
                itemStartUi.setDescription(description);
                itemStartUi.setId(oldid);         //привязал тот же id
                tracker.update(itemStartUi);      //вызвал метод update
                for (Item item : tracker.getAll()) {
                    System.out.println(item.getName());
                }

            }
            if (c == DELETE) {                     //удаляет первый элемент
                Item[] itemAr = new Item[100];     //создал массив, чтобы вытащить id-шник объекта
                itemAr = tracker.getAll();
                String oldid = itemAr[0].getId();  //взял старый id первого объекта
                Item itemDel = new Item();         //создал новый элемент
                itemDel.setId(oldid);
                tracker.delete(itemDel);
                for (Item item : tracker.getAll()) {
                    System.out.println(item.getName());
                }

            }
            if (c == FIND_BY_ID) {
                for (Item item : tracker.getAll()) {
                    System.out.println(item.getId());
                }
                Item item = new Item();
                String id = input.ask("Please, enter the tak's id: ");
                item = tracker.findById(id);
                System.out.println(item.getName());
                System.out.println(item.getDescription());

            }
            if (c == FIND_BY_NAME) {
                Item item = new Item();
                String name = input.ask("Please, enter the tak's name: ");
                item = tracker.findByName(name);
                System.out.println(item.getName());
                System.out.println(item.getDescription());
            }
            if (c == EXIT) {
                break;
            }
            if (c != EXIT) {
                System.out.println("0. Add new Item");
                System.out.println("1. Show all items");
                System.out.println("2. Edit item");
                System.out.println("3. Delete item");
                System.out.println("4. Find item by Id");
                System.out.println("5. Find items by name");
                System.out.println("6. Exit Program");
            }
            k++;
         */
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select:"));
            menu.select(key);
        } while ("y".equals(this.input.ask("Exit? y")));
        return null;
    }


    /**
     * Method main.
     * @param args It is String.
     */
    public static void main(String[] args) {
       Input input = new ConsoleInput();
       Tracker tracker = new Tracker();
       new StartUi(input, tracker).init();
    }
}
