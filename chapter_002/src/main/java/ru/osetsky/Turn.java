package ru.osetsky;

/**
 *Class Calculate решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Turn {
	/**
	 * method back.
	 * @param values It's array
	 * @return values.
	 */
	public int[] back(int[] values) {
		for (int i = 0; i < values.length / 2; i++) {
		int perestanovka = values[i];
		values[i] = values[values.length - 1 - i];
		values[values.length - 1 - i] = perestanovka;
		}
		return values;
	}

}