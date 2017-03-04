package ru.osetsky;

import java.util.Arrays;

public class Duplicate {
	public String[] dup(String[] arr){
		int index = 0;
		int counter = 0;
		String[] nodup = new String[arr.length];
		for(int i=0; i<arr.length; i++){
			counter = 0;
			for (int j=0;j<index;j++) {
				if (nodup[j].equals(arr[i])) {
					counter++;
				}
			}
			if (counter == 0) {
					nodup[index++]=arr[i];
			}
		}
		nodup = Arrays.copyOf(nodup, index);
		return nodup;
	}		
}