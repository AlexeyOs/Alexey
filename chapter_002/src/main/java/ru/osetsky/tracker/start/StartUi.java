package ru.osetsky.tracker.start;

import ru.osetsky.paint.Strategy;
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
    public StartUi init() {
        /**
        Tracker tracker = new Tracker();
        ConsoleInput input = new ConsoleInput();
         */
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        String comand=input.ask("Select: ");
        int k=0;
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
                    System.out.println("Name = "+ item.getName());
                    System.out.println("Descption = " + item.getDescription());
                }
            }
            if (c == EDIT) {
                String name = input.ask("Please, enter the tak's id: ");
                Item itemStartUi = new Item();
                itemStartUi.setName(name);
                String description = input.ask("Please, enter description");
                itemStartUi.setDescription(description);
                tracker.update(itemStartUi);
                for (Item item : tracker.getAll()) {
                    System.out.println(item.getName());
                }

            }
            if (c == DELETE) {
                String name = input.ask("Please, enter the tak's id: ");
                Item itemStartUi = new Item();
                itemStartUi.setId(name);
                tracker.delete(itemStartUi);
                for (Item item : tracker.getAll()) {
                    System.out.println(item.getName());
                }

            }
            if (c == FIND_BY_ID) {
                String id = input.ask("Please, enter the tak's id: ");
                tracker.findById(id);
                for (Item item : tracker.getAll()) {
                    System.out.println(item.getId());
                    System.out.println(item.getDescription());
                }
            }
            if (c == FIND_BY_NAME) {
                String name = input.ask("Please, enter the tak's name: ");
                tracker.findByName(name);
                for (Item item : tracker.getAll()) {
                    System.out.println(item.getName());
                    System.out.println(item.getDescription());
                }
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
        }
        return null;
    }


    /**
     * Method main.
     * @param args It is String.
     */
    public static void main(String[] args) {
       Input input = new ConsoleInput();
       Tracker tracker = new Tracker();
       new StartUi(input,tracker).init();
    }
}
