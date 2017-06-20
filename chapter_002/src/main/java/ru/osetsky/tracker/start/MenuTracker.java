package ru.osetsky.tracker.start;


import ru.osetsky.tracker.models.Item;

/**
 * Created by koldy on 16.06.2017.
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;

    private UserAction[] actions = new UserAction[5];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = this.input;
        this.tracker = this.tracker;
    }

    public void fillActions() {
       //how to fill it
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);

    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker){
            String name = input.ask("Please, enter the tak's name: ");
            Item itemStartUi = new Item();
            itemStartUi.setName(name);
            String description = input.ask("Please, enter description");
            itemStartUi.setDescription(description);
            tracker.add(itemStartUi);
        }
        public String info() {
            return String.format("$s. $s",this.key(), "Add the new item.");
        }
    }

    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }
        public void execute(Input input, Tracker tracker){
           for (Item item: tracker.getAll()) {
               System.out.println(String.format("%s. %s", item.getId(), item.getName()));
           }
        }
        public String info() {
            return String.format("$s. $s",this.key(), "Show all items.");
        }
    }
}
