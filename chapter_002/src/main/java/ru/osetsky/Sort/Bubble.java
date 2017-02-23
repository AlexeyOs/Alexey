package osetsky.sort;

public class Bubble {
	public int[] bub(int[] a) {
		for (int i=0; i<10;i++){
			int k=0;
			for (int j=0; j<10; j++){
				if (a[j]>a[j+1]) {
					k = a[j];
					a[j]=a[j+1];
					a[j+1]=k;
				}
			}
		}
		return a;				 
	}
}