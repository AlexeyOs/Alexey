package ru.osetsky.tracker.start;
/**
 * Created by koldy on 23.03.2017.
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ru.osetsky.tracker.models.Item;

/**
 * public Class Tracker.
 */

public class Tracker {
	/**
	 * Array items.
	 */
	private List<Item> items = new ArrayList<Item>();
	/**
	 * Field is static from util.
	 */
	private static final Random RN = new Random();
	/**
	 * Method add.
	 * @param item Type is class Item.
	 * @return item Type is class Item.
	 */
	public Item add(Item item) throws SQLException {
		item.setId(this.generateId());
		this.items.add(item);
		DBConnect dbConnect = new DBConnect();
		dbConnect.addIntoTable(item);
		dbConnect.commit();
		return item;
	}
	/**
	 * Method update.
	 * @param item Type is class Item.
	 */
	public void update(Item item) throws SQLException {
		DBConnect dbConnect = new DBConnect();
		dbConnect.updateItem(item);
		dbConnect.commit();
	}
	/**
	 * Method delete.
	 * @param item Type is class Item.
	 */
	public void delete(Item item) throws SQLException {
		DBConnect dbConnect = new DBConnect();
		dbConnect.deleteTable(item.getCreate());
		System.out.println(item.getCreate());
		dbConnect.commit();
	}
	/**
	 * Method getAll.
	 * @return item Type is class Item.
	 */
	public List<Item> getAll() throws SQLException {
		DBConnect dbConnect = new DBConnect();
		List<Item> result = dbConnect.getAllItems();
		dbConnect.commit();
		return result;
	}
	/**
	 * Method findByName.
	 * @param name Type is String.
	 * @return name Type is Item.
	 */
	public Item findByName(String name) throws SQLException {
		DBConnect dbConnect = new DBConnect();
		Item result = dbConnect.findByName(name);
		dbConnect.commit();
		return result;
	}
	/**
	 * Method findById.
	 * @param id Type is Spring.
	 * @return result Type is Item.
	 */
	protected Item findById(String id) throws SQLException {
		DBConnect dbConnect = new DBConnect();
		Item result = dbConnect.findItem(Long.parseLong(id));
		dbConnect.commit();
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