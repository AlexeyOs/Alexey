package ru.osetsky.tracker.models;
/**
 *@author osetsky
 *@since 24.03.2017
*/
public class Item {
	/**
	 * Старая версия id, сейчас используется create.
	 */
	private String id;
	/**
	 * Имя Item.
	 */
	private String name;
	/**
	 * Описение Item.
	 */
	private String description;
	/**
	 * идентификатор записи.
	 */
	private long create;
	/**
	 * Коструктор Item без начальных параметров, используется при подключении к базе данных.
	 */
	public Item() {

	}
	/**
	 * Коструктор Item с параметрами.
	 */
	public Item(String name, String description, long create) {
		this.name = name;
		this.description = description;
		this.create = create;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {

		return this.name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
	/**
	 * Присваивается иднетификатор записи.
	 * @param create Идентификатор типа long, в этом принципиальное отличия от старого id типа String(разница при
	 * 					сравнении объектов.
	 */
	public void setCreate(long create) {
		this.create = create;
	}
	/**
	 * Метод козвращающий текущий идентификатор.
	 */
	public long getCreate() {
		return this.create;
	}

	public void setId(String id) {
		this.id = id;
	}

	public  String getId() {
		return this.id;
	}
}