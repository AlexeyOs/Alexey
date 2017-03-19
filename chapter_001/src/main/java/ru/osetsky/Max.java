package ru.osetsky;

/**
 *Class Calculate решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Max {
	/**
	* method max.
	* @param first first param
	* @param second second param
	* @return first
	*/
	public int max(int first, int second) {
		return first >= second ? first : second;
	}
	/**
	* method max.
	* @param first first param
	* @param second second param
	* @param third third param
	* @return max
	*/
	public int max(int first, int second, int third) {
		return max(first, max(second, third));
	}
}