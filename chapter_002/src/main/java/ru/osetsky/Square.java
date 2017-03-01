package ru.osetsky;

public class Square {
	public int[][] povorot(int[][] a){
		int m;
		int n=2;
		for (int i=0; i<=n%2;i++){ 
			for (int k=0; k<=(n-i);k++){
			m=a[i][k];
			a[i][k]=a[n-k+1][i];
			a[n-k+1][i]=a[n-i-1][n-k+1];
			a[n-i+1][n-k+1]=a[k][n-i+1];
			a[k][n-i+1]=m;
			}
		}
		return a;
	}
}