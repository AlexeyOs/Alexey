package ru.osetsky;

public class Factorial {
	public int factor = 1;
	public int factorial(int numeral) {
		for (int index=1;index<numeral;index++){
			factor = factor*index;
		}			
		return factor;
	}
}