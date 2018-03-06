//package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class MinionChef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		MinionChefInputReader in=new MinionChefInputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
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

			for(int j=0;j<N;j++) {
				A[j]=Long.parseLong(line2[j]);
				sum=sum+A[j];
			}

//			out.println("sum:"+sum);
/*			long sum=0;

			for(int j=0;j<N;j++) {
				A[j]=Long.parseLong(line2[j]);
				sum=sum+A[j];
			}
			
			for(int j=0;j<N;j++) {
				if(A[j]>max) {
					max=A[j];
				}				
			}
						
			if(N==H)
				out.println(max);
			else {
				if(sum%H==0)
					out.println((long)(Math.ceil((double)sum/(double)H+1)));
				else
					out.println((long)(Math.ceil((double)sum/(double)H)));
				
			}*/
			
			
			for(int j=0;j<N;j++) {
				if(A[j]>max) {

					max=A[j];

				}				
			}
			
			long min=-1;
			long cnt=Long.MAX_VALUE;
			if(N==H) {
				out.println(max);
//				result[z++]=max;

			}							
			else {
			long kMin=(long)Math.ceil((sum)/(H+0.0));	
//			out.println("kmin:"+kMin);
				while(cnt>H) {					
					
					cnt=0;
					for(int j=0;j<N;j++) {
						if(A[j]<=kMin) {
							cnt=cnt+1;
						}
						else {
							cnt=cnt+(long)Math.ceil((A[j]+0.0)/kMin);
						}
						
					}
					kMin=kMin+1;
				}
				
				out.println(kMin-1);
//				result[z++]=max;
				
			}
		}
//		for(int j=0;j<nCases;j++) {
//			out.println(result[j]);
//		}
		out.close();
	}

}
class MinionChefInputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public MinionChefInputReader(InputStream stream) {
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