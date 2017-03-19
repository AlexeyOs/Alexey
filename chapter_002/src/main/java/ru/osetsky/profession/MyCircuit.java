package ru.osetsky;

/**
 *Class MyCircuit решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class MyCircuit {
	/**
	 * method main.
	 * @param args It is String array.
	 */
	public static void main(String[] args) {
		Profession profession = new Profession("name", "diplom");
		System.out.println(profession.getName() + " " + profession.getDiplom());
	}
}