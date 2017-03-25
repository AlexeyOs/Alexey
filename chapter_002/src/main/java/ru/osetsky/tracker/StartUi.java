package ru.osetsky.tracker;

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
        String name = input.ask("Please, enter the tak's name: ");
        Tracker tracker = new Tracker();
        tracker.add(new Task(name, "first desc"));
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }
    }
}
