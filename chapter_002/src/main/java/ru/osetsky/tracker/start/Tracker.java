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
	 * Массив объектов пользователе(пользователь рассматриватьеся как запись).
	 */
	private List<Item> items = new ArrayList<Item>();
	/**
	 * Поля используется для генерирования id.
	 */
	private static final Random RN = new Random();
	/**
	 * Метода отправляет данные в класс отвечающий за соединение с базой данный,
	 * и запрашивает добавление данных в базу.
	 * @param item Тип записи.
	 * @return item Тип записи.
	 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items.add(item);
		try (DBConnect dbConnect = new DBConnect()) {
			dbConnect.addIntoTable(item);
			dbConnect.commit();
		} catch (Exception e) {
			System.out.println("Ошибка при добавлении в классе Tracker");
		}
		return item;
	}
	/**
	 * Метода отправляет данные в класс отвечающий за соединение с базой данный,
	 * и запрашивает обновление данных в базе.
	 * @param item Тип записи.
	 */
	public void update(Item item) {
		try (DBConnect dbConnect = new DBConnect()) {
			dbConnect.updateItem(item);
			dbConnect.commit();
		} catch (Exception e) {
			System.out.println("Ошибка при обновлении в классе Tracker");
		}
	}
	/**
	 * Метода отправляет данные в класс отвечающий за соединение с базой данный,
	 * и запрашивает удаление данных в базе.
	 * @param item Тип записи.
	 */
	public void delete(Item item) {
		try (DBConnect dbConnect = new DBConnect()) {
			dbConnect.deleteTable(item.getCreate());
			System.out.println(item.getCreate());
			dbConnect.commit();
		} catch (Exception e) {
			System.out.println("Ошибка при удалении в классе Tracker");
		}
	}
	/**
	 * Метода запрашивает данные из класса отвечающего за соединение с базой данный.
	 * @return Тип записи.
	 */
	public List<Item> getAll() {
		try (DBConnect dbConnect = new DBConnect()) {
			List<Item> result = dbConnect.getAllItems();
			dbConnect.commit();
			return result;
		} catch (Exception e) {
			System.out.println("Ошибка при запросе всех объектов в классе Tracker");
		}
		return null;
	}
	/**
	 * Метода запрашивает объект с заданным именем из класса отвечающего за соединение с базой данный.
	 * @param name Имя искомого объекта.
	 * @return name Тип объекта.
	 */
	public Item findByName(String name) {
		try (DBConnect dbConnect = new DBConnect()) {
			Item result = dbConnect.findByName(name);
			dbConnect.commit();
			return result;
		} catch (Exception e) {
			System.out.println("Ошибка поиске объектов по имени в классе Tracker");
		}
		return null;
	}
	/**
	 * Метода запрашивает объект с заданным id из класса отвечающего за соединение с базой данный.
	 * @param id Индентификатор объетка.
	 * @return result Тип записи.
	 */
	public Item findById(String id) {
		try (DBConnect dbConnect = new DBConnect()) {
			Item result = dbConnect.findItem(Long.parseLong(id));
			dbConnect.commit();
			return result;
		} catch (Exception e) {
			System.out.println("Ошибка поиска объектов по id в классе Tracker");
		}
		return null;
	}
	/**
	 * Метод генерирующий уникальный идентификатор.
	 * @return String.
	 */
	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}

}