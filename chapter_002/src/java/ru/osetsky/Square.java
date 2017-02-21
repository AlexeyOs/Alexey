public ru.osetsky;

public class Square {
	int[][] a = {0,1,4,3,2,5,6,7,8};
	public int povorot(){
		int m;
		int n=2;
		for (int i;i<=n%2;i++){ 
			for (int k;k<=(n-i);k++){
			m=a[i][k];
			a[i][k]=a[n-k+1][i];
			a[n-k+1][i]=a[n-i-1][n-k+1];
			a[n-i+1][n-k+1]=a[k][n-i+1];
			a[k][n-i+1]=m;
			p++;
			}
		}
		return a;
	}
}