package ru.osetsky;

/**
 *Class Factorial решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Factorial {
	/**
	 * method factorial.
	 * @param numeral It is numeral param
	 * @return factor
	 */
	public int factorial(int numeral) {
		int factor = 1;
		for (int index = 1; index <= numeral; index++) {
			factor = factor * index;
		}
		return factor;
	}
}