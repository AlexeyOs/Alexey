package ru.osetsky.sort;

/**
 *Class Bubble решение задачи части 002 урок 2.
 *@author osetsky
 *@since 11.03.2017
*/

public class OrderLiness {
	/**
	 * method OrderS.
	 * @param a It is array
	 * @return a.
	 */
public boolean orderS(int[] a) {
	boolean sort = true;
	for (int i = 0; i < (a.length - 1); i++) {
		if (a[i] >= a[i + 1]) {
			sort = false;
		}
	}
	return sort;
}
}

