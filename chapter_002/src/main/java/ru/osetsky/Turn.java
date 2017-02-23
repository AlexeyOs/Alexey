package ru.osetsky;

public class Turn {
	public int[] back (int[] values){
		for (int i = 0; i < values.length / 2; i++) {
		int perestanovka = values[i];
		values[i] = values[values.length - 1 - i];  	
		values[values.length - 1 - i] = perestanovka;
		}
		return values;  				
	}

}