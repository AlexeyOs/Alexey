package ru.osetsky.profession;

/**
 *Class Profession решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Profession {
	/**
	 * field is name.
	 */
	private String name;
	/**
	 * field is diplom.
	 */
	private String diplom;
	/**
	 * method Profession.
	 */
	public Profession() {
	}
	/**
	 * method Profession.
	 * @param name is String
	 * @param diplom is String
	 */
	public Profession(String name, String diplom) {
		this.name = name;
		this.diplom = diplom;
	}
	/**
	 * method getName.
	 * @return name is String.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * method setName.
	 */
	public void setName() {
		this.name = name;
	}
	/**
	 * method getDiplom.
	 * @return diplom is String.
	 */
	public String getDiplom() {
		return this.diplom;
	}
	/**
	 * method setDiplom.
	 */
	public void setDiplom() {
		this.diplom = diplom;
	}
}