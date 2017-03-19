package ru.osetsky;

import java.util.Arrays;

/**
 *Class Duplicate решение задачи части 002 урок 2.
 *@author osetsky
 *@since 05.08.2017
*/

public class Duplicate {
	/**
	 * method dup is public.
	 * @param arr a parametr of dup
	 * @return nodup
	 */
	public String[] dup(String[] arr) {
		int index = 0;
		int counter = 0;
		String[] nodup = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			counter = 0;
			for (int j = 0; j < index; j++) {
				if (nodup[j].equals(arr[i])) {
					counter++;
				}
			}
			if (counter == 0) {
					nodup[index++] = arr[i];
			}
		}
		nodup = Arrays.copyOf(nodup, index);
		return nodup;
	}
}