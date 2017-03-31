package ru.osetsky.tracker.start;

import ru.osetsky.tracker.models.Item;
import ru.osetsky.tracker.models.Task;

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
        if (c == 0) {
            String name = input.ask("Please, enter the tak's name: ");
            tracker.add(new Task(name, "first desc"));
        }
        if (c == 4) {
            String id = input.ask("Please, enter the tak's id: ");
            tracker.findById(id);
            for (Item item : tracker.getAll()) {
                System.out.println(item.getName());
                System.out.println(item.getDescription());
            }
        }
    }
}
