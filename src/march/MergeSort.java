package march;

import java.util.Arrays;

public class MergeSort {
/*		public static void main(String args[]) {
			MergeSort obj=new MergeSort();
			long arr[]= {10,12,1,5,8};
			arr=obj.sort(arr, arr.length);
			for(int i=0;i<arr.length;i++) {
				System.out.println(arr[i]);
			}
		}*/

	public long[] sort(long arr[],int n) {
		long[] A, B, C;
		if(n==1) {
			return arr;
		}
		A=sort(Arrays.copyOfRange(arr, 0, n/2),Arrays.copyOfRange(arr, 0, n/2).length);
		B=sort(Arrays.copyOfRange(arr, n/2, n),Arrays.copyOfRange(arr, n/2, n).length);
		C=merge(A,B,n);
		return C;
	}
	public long[] merge(long[] A, long[] B, int n) {
		long[] C=new long[n];
		int i=0,j=0;
		for(int k=0;k<n;k++) {
			if(i==A.length) {
				C[k]=B[j];j++;
			}
			else if(j==B.length) {
				C[k]=A[i];i++;
			}
			else {
				if(A[i]<B[j]) {
					C[k]=A[i];
					i++;
				}
				else {
					C[k]=B[j];
					j++;
				}
				
			}
				
		}
		return C;
	}

}
