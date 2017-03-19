package ru.osetsky;

/**
 *Class Calculate решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Counter {
	/**
	 * method add.
	 * @param start first param
	 * @param finish second param
	 * @return result
	 */
	public int add(int start, int finish) {
		int sum = 0;
		while (start < finish) {
			start++;
			if ((start % 2) == 0) {
				sum += start;
			}
		}
		return sum;
	}
}