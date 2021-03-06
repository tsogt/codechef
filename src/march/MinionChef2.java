package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class MinionChef2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		MinionChef2InputReader in=new MinionChef2InputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		
		MinionChef2MergeSort obj=new MinionChef2MergeSort();
		
		int nCases=in.nextInt();
		long[] result=new long[nCases];
		int z=0;
		for(int i=0;i<nCases;i++) {
			String line1=in.nextLine();
			int N=Integer.parseInt(line1.split(" ")[0]);
			long H=Long.parseLong(line1.split(" ")[1]);
			long max=0;
			String line2[]=in.nextLine().split(" ");
			long A[]=new long[N];
			long sum=0;
			for(int j=0;j<N;j++) {
				A[j]=Long.parseLong(line2[j]);
			
			}

			A=obj.sort(A, N);


			long min=-1;
			long cnt=0;
			if(N==H) {
				out.println(A[N-1]);
//				result[z++]=max;

			}							
			else {
				int kindex=0;
				max=A[N-1];
				while(cnt<H) {									
					
					max=max-1;
					kindex=0;
					for(int j=N-1;j>=0;j--) {
						if(A[j]<=max) {
							kindex=j;
							break;
						}					
					}				
					cnt=kindex+1;
					for(int j=kindex+1;j<N;j++) {
						if(A[j]%max==0) 
							cnt=cnt+A[j]/max;
						else
							cnt=cnt+A[j]/max+1;
					}
					
					
				}
				max=max+1;
				out.println(max);
//				result[z++]=max;
				
			}
		}
//		for(int j=0;j<nCases;j++) {
//			out.println(result[j]);
//		}
		out.close();
	}

}
class MinionChef2InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public MinionChef2InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    public String nextLine() {
    	String in=null;
		try {
			in = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return in;
    }

}


class MinionChef2MergeSort {
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
