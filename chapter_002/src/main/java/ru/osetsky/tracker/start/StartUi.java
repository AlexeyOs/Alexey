package ru.osetsky.tracker.start;

/**
 * Created by koldy on 25.03.2017.
 */
public class StartUi {
	/**
     * Array is integer for menu.
     */
    private int[] ranges  = new int[] {0, 1, 2, 3, 4, 5};
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
     * Method StartUi.
     * @return null .
     */
    public StartUi init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            //int key = Integer.valueOf(input.ask("Select:"));
            //menu.select(key);
            menu.select(input.ask("select:", ranges));
        } while (!"y".equals(this.input.ask("Exit? y")));
        return null;
    }


    /**
     * Method main.
     * @param args It is String.
     */
    public static void main(String[] args) {
       Input input = new ValidateInput();
       Tracker tracker = new Tracker();
       new StartUi(input, tracker).init();
    }
}
