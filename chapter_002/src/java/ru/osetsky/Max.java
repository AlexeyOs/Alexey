package ru.osetsky;

public class Max {
	public int max (int first,int second) {
		int result = first >= second ? first : second;
		return result;
	}
	
	public int max (int first, int second, int third) {
		
		int resultmax1 = first >= second ? first : second;
		int resultmax2 = first >= third ? first : third;
		int resultmax3 = second >= third ? second : third;
		int resultmax4 = resultmax1 >= resultmax2 ? resultmax1 : resultmax2;
		int resultmax5 = resultmax4 >= resultmax3 ? resultmax4 : resultmax3;
		return resultmax5;
		
	}
}