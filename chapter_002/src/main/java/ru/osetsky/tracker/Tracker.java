package ru.osetsky.tracker;
/**
 * Created by koldy on 23.03.2017.
 */
import java.util.Random;

/**
 * public Class Tracker.
 */

public class Tracker {
	/**
	 * Array items.
	 */
	private Item[] items = new Item[10];
	/**
	 * Field is position.
	 */
	private int position = 0;
	/**
	 * Field is static from util.
	 */
	private static final Random RN = new Random();
	/**
	 * Method add.
	 * @param item Type is class Item.
	 * @return item Type is class Item.
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[position++] = item;
		return item;
	}
	/**
	 * Method update.
	 * @param item Type is class Item.
	 */
	public void update(Item item) {
		for (int i = 0; i != this.items.length; i++) {
			if (this.items[i] != null && this.items[i].getId() == item.getId()) {
				this.items[i] = item;
				break;
			}
		}
	}
	/**
	 * Method delete.
	 * @param item Type is class Item.
	 */
	public void delete(Item item) {
		for (int i = 0; i != this.items.length; i++) {
			if (this.items[i] != null && this.items[i].getId() == item.getId()) {
				this.items[i] = item;
				break;
			}

		}
	}
	/**
	 * Method findAll.
	 * @return item Type is class Item.
	 */
	public Item[] findAll() {
		Item[] result = new Item[this.items.length];
		for (int i = 0; i != this.items.length; i++) {
				result[i] = this.items[i];
		}
		return result;
	}
	/**
	 * Method getAll.
	 * @return item Type is class Item.
	 */
	public Item[] getAll() {
		Item[] result = new Item[this.position];
		for (int i = 0; i != this.position; i++) {
			result[i] = this.items[i];
		}
		return result;
	}
	/**
	 * Method findByName.
	 * @param name Type is String.
	 * @return name Type is Item.
	 */
	public Item findByName(String name) {
		Item result = null;
		for (Item item : items) {
				if (item != null && item.getName().equals(name)) {
					result = item;
			}
		}
		return result;
	}
	/**
	 * Method findById.
	 * @param id Type is Spring.
	 * @return result Type is Item.
	 */
	protected Item findById(String id) {
		Item result = null;
		for (Item item : items) {
				if (item != null && item.getId().equals(id)) {
					result = item;
					break;
			}
		}
		return result;
	}
	/**
	 * Method generateId.
	 * @return String.
	 */
	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}

}