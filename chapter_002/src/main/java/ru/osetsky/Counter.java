package ru.osetsky;

public class Counter {
	public int add (int start, int finish){
		int count=start;
		int sum;
		while (count>finish) {
			count++;
			if ( (count % 2) == 0) {
				sum = sum + count;
			}		
		}
		return sum;
	}
}