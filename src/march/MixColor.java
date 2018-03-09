package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class MixColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		MixColorInputReader in=new MixColorInputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		
		MixColorMergeSort obj=new MixColorMergeSort();
		
		int nCases=in.nextInt();
		for(int i=0;i<nCases;i++) {
			int N=in.nextInt();
			String Astring[]=in.nextLine().split(" ");
			long A[]=new long[N];
			for(int j=0;j<N;j++) {
				A[j]=Long.parseLong(Astring[j]);
			}
			A=obj.sort(A,N);
			out.println(obj.mixnum);
			
		}
		out.close();
	}

}


class MixColorInputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public MixColorInputReader(InputStream stream) {
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

class MixColorMergeSort {
/*		public static void main(String args[]) {
			MergeSort obj=new MergeSort();
			long arr[]= {10,12,1,5,8};
			arr=obj.sort(arr, arr.length);
			for(int i=0;i<arr.length;i++) {
				System.out.println(arr[i]);
			}
		}*/
	static int mixnum=0;
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
				else if(A[i]==B[j]) {
					C[k]=B[j];
					j++;			
					mixnum=mixnum+1;
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
