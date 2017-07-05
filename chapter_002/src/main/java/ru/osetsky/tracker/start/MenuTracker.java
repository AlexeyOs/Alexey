package ru.osetsky.tracker.start;

import ru.osetsky.tracker.models.Item;

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
        this.actions[position++] = new AddItem();
        this.actions[position++] = new ShowItems();
        this.actions[position++] = new EditItem();
        //this.actions[position++] = new DeleteItem();
        this.actions[position++] = new FindItemById();
        this.actions[position++] = new FindItemByName();
    }
    public void addAction(UserAction action) {
        this.actions[position++] = action;
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
    public class AddItem implements UserAction {
		/**
		 * Method key is public.
		 * @return integer.
		 */
        public int key() {
            return 0;
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
    private static class ShowItems implements UserAction {
		/**
		 * Method key is public.
		 * @return integer.
		 */
        public int key() {
            return 1;
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
    private static class EditItem implements UserAction {
		/**
		 * Method key is public.
		 * @return integer.
		 */
        public int key() {
			return 2;
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
    public static class DeleteItem implements UserAction {
		/**
		 * Method key is public.
		 * @return integer.
		 */
        public int key() {
			return 3;
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
    public static class FindItemById implements UserAction {
		/**
		 * Method key is public.
		 * @return integer.
		 */
        public int key() {
			return 4;
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
    public static class FindItemByName implements UserAction {
		/**
		 * Method key is public.
		 * @return integer.
		 */
        public int key() {
			return 5;
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
