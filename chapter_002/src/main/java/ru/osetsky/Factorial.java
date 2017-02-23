package ru.osetsky;

public class Factorial {
	public int factorial(int numeral) {
		int factor = 1;
		for (int index=1;index<numeral;index++){
			factor = factor*index;
		}			
		return factor;
	}
}