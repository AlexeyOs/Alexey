package ru.osetsky.tracker.start;

import ru.osetsky.tracker.models.Item;

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
     * FIND_BY_ID is constant.
     */
    static final int FIND_BY_ID = 4;
    /**
     * Method main.
     * @param args It is String.
     */
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        Tracker tracker = new Tracker();
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        int c = input.comand();
        if (c == ADD) {
            String name = input.ask("Please, enter the tak's name: ");
            Item item = new Item();
            item.setName(name);
            item.setDescription("first desc");
            tracker.add(item);
        }
        if (c == FIND_BY_ID) {
            String id = input.ask("Please, enter the tak's id: ");
            tracker.findById(id);
            for (Item item : tracker.getAll()) {
                System.out.println(item.getName());
                System.out.println(item.getDescription());
            }
        }
    }
}
