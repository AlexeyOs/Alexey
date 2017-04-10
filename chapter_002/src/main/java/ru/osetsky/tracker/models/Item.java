package ru.osetsky.tracker.models;
/**
 *Class Item решение задачи части 002 урок 2.
 *@author osetsky
 *@since 24.03.2017
*/
public class Item {
	/**
	 * Fild is id.
	 */
	private String id;
	/**
	 * Fild is name.
	 */
	private String name;
	/**
	 * Fild is description.
	 */
	private String description;
	/**
	 * Fild is create.
	 */
	private long create;
	/**
	 * Constructor is Item.
	 */
	public Item() {

	}
	/**
	 * Constructor is Item.
	 * @param name It is String.
	 * @param description It is String.
	 * @param create It is long;
	 */
	public Item(String name, String description, long create) {
		this.name = name;
		this.description = description;
		this.create = create;
	}
	/**
	 * Method is setName.
	 * @param name It is String.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Method is getName.
	 * @return name It is String.
	 */
	public String getName() {

		return this.name;
	}
	/**
	 * Method is setDescription.
	 * @param description It is String.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Method is setDescription.
	 * @return description It is String.
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * Method is setCreate.
	 * @param create It is long.
	 */
	public void setCreate(long create) {
		this.create = create;
	}
	/**
	 * Method is getCreate.
	 * @return create It is long.
	 */
	public long getCreate() {
		return this.create;
	}
	/**
	 * Method is setId.
	 * @param id It is String.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Method is getId.
	 * @return id It is String.
	 */
	public  String getId() {
		return this.id;
	}
}