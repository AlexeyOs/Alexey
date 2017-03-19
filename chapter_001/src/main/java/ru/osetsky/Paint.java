package ru.osetsky;

/**
 *Class Calculate решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Paint {
	/**
	 * method piramid.
	 * @param h It height of the tree
	 * @return builder.
	 */
	public String piramid(int h) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < h; i++) {
			for (int i2 = 0; i2 < i; i2++) {
				builder.append(" ");
			}

			for (int i2 = 0; i2 <= i; i2++) {
				builder.append("^");
				if (i2 > 0) {
					builder.append(" ");
				}
			}
		}
		return builder.toString();
	}
}