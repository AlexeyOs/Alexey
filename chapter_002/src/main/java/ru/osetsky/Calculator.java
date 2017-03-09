package ru.osetsky;

/**
 *Class Calculate решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Calculator {
	/**
	* Поле result не публичное.
	*/
	private double result;
	/**
	* Конструктор, вывод строки в консоль.
	* @param first It is first argument
	* @param second It is second argument
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	* Конструктор, вывод строки в консоль.
	* @param first first argument
	* @param second second argument
	*/
	public void substruct(double first, double second) {
		this.result = first - second;
	}
		/**
	* Конструктор, вывод строки в консоль.
	* @param first first argument
	* @param second second argument
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}
	/**
	* Конструктор, вывод строки в консоль.
	* @param first first argument
	* @param second second argument
	*/
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	/**
	 This method returns the result.
	 *@return Return of result
	 */
	public double getResult() {
		return result;
	}
}