package ru.osetsky;

public class Counter {
	public int sum;
	public int count;
	public int add (int start, int finish){
		count=start;
		while (count>finish) {
			count++;
			if ( (count % 2) == 0) {
				sum = sum + count;
			}		
		}
		return sum;
	}
}