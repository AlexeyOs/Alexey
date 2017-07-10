package ru.osetsky.tracker.start;

import ru.osetsky.tracker.models.Item;
import ru.osetsky.tracker.templates.BaseAction;

/**
 * Created by koldy on 16.06.2017.
 */
public class MenuTracker {
	/**
     * Field is private for input.
     */
    private Input input;
	/**
     * Field is private for tracker.
     */
    private Tracker tracker;
	/**
     * Array is private.
     */
    private UserAction[] actions = new UserAction[6];
    /**
     * Field is position type int.
     */
    private int position = 0;
	/**
     * Constructor MenuTracker  is public.
	 * @param input type Input
	 * @param tracker type Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
	/**
     * Method fillActions is public.
     */
    public void fillActions() {
       //how to fill it
        this.actions[position++] = new AddItem(0, "Add");
        this.actions[position++] = new ShowItems(1, "Show");
        this.actions[position++] = new EditItem(2, "Edit");
        this.actions[position++] = new DeleteItem(3, "Delete");
        this.actions[position++] = new FindItemById(4, "FindId");
        this.actions[position++] = new FindItemByName(5, "FindName");
    }
	/**
     * Method select is public.
	 * @param key type integer.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
	/**
     * Method show is public.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
	/**
     * Interior class AddItem is private.
     */
    public class AddItem extends BaseAction {
        /**
         *
         * @param key It is Integer
         * @param name It is String.
         */
        AddItem(int key, String name) {
            super(key, name);
        }
        /**
		 * Method execute is public.
		 * @param input type Input
		 * @param tracker type Tracker.
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
		 * Method info is public.
		 * @return String.
		 */
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }
	/**
     * Interior class ShowItems is private.
     */
    private static class ShowItems extends BaseAction {
        /**
         * @param key It is Integer
         * @param name It is String.
         */
        private ShowItems(int key, String name) {
            super(key, name);
        }
		/**
		 * Method execute is public.
		 * @param input type Input
		 * @param tracker type Tracker.
		 */
        public void execute(Input input, Tracker tracker) {
           for (Item item: tracker.getAll()) {
               System.out.println(String.format("%s. %s", item.getId(), item.getName()));
           }
        }
		/**
		 * Method info is public.
		 * @return String.
		 */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }
	/**
     * Interior class EditItem is private.
     */
    private static class EditItem extends BaseAction {
        /**
         * @param key It is Integer
         * @param name It is String.
         */
        private EditItem(int key, String name) {
            super(key, name);
        }
		/**
		 * Method execute is public.
		 * @param input type Input
		 * @param tracker type Tracker.
		 */
        public void execute(Input input, Tracker tracker) {
            //изменяет первый элемент
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
		/**
		 * Method info is public.
		 * @return String.
		 */
        public String info() {
			return String.format("%s. %s", this.key(), "Edit item");
		}
    }
	/**
     * Interior class DeleteItem is private.
     */
    public static class DeleteItem extends BaseAction {
        /**
         * @param key It is Integer
         * @param name It is String.
         */
        public DeleteItem(int key, String name) {
            super(key, name);
        }
		/**
		 * Method execute is public.
		 * @param input type Input
		 * @param tracker type Tracker.
		 */
        public void execute(Input input, Tracker tracker) {
            //удаляет первый элемент
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
		/**
		 * Method info is public.
		 * @return String.
		 */
        public String info() {
			return String.format("%s. %s", this.key(), "Delete item");
		}
    }
	/**
     * Interior class FindItemById is private.
     */
    public static class FindItemById extends BaseAction {
        /**
         * @param key It is Integer
         * @param name It is String.
         */
        public FindItemById(int key, String name) {
            super(key, name);
        }
		/**
		 * Method execute is public.
		 * @param input type Input
		 * @param tracker type Tracker.
		 */
        public void execute(Input input, Tracker tracker) {

            for (Item item : tracker.getAll()) {
                System.out.println(item.getId());
            }
            Item item = new Item();
            String id = input.ask("Please, enter the tak's id: ");
            item = tracker.findById(id);
            System.out.println(item.getName());
            System.out.println(item.getDescription());

        }
		/**
		 * Method info is public.
		 * @return String.
		 */
        public String info() {
			return String.format("%s. %s", this.key(), "Find item by Id");
		}
    }
	/**
     * Interior class FindItemByName is private.
     */
    public static class FindItemByName extends BaseAction {
        /**
         * @param key It is Integer
         * @param name It is String.
         */
        public FindItemByName(int key, String name) {
            super(key, name);
        }
		/**
		 * Method execute is public.
		 * @param input type Input
		 * @param tracker type Tracker.
		 */
        public void execute(Input input, Tracker tracker) {
            Item item = new Item();
            String name = input.ask("Please, enter the tak's name: ");
            item = tracker.findByName(name);
            System.out.println(item.getName());
            System.out.println(item.getDescription());
        }
		/**
		 * Method info is public.
		 * @return String.
		 */
        public String info() {
			return String.format("%s. %s", this.key(), "Find items by name");
		}
    }
}
