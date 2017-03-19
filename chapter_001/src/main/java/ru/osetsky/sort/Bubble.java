package osetsky.sort;

/**
 *Class Bubble решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Bubble {
	/**
	 * method bub.
	 * @param a It is array
	 * @return a.
	 */
	public int[] bub(int[] a) {
		for (int i = 0; i < 10; i++) {
			int k = 0;
			for (int j = 0; j < 10; j++) {
				if (a[j] > a[j + 1]) {
					k = a[j];
					a[j] = a[j + 1];
					a[j + 1] = k;
				}
			}
		}
		return a;
	}
}