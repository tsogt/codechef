package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


class chefAndGlove {
	public static void main(String[] args) {
		InputStream input=System.in;
		InputReader in=new InputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		
		chefAndGlove obj=new chefAndGlove();
		
		int nCases=in.nextInt();
		String outStr[]=new String[nCases];
		for(int i=0;i<nCases;i++) {
			
			int nFinger=in.nextInt(); 
			String[] line1=in.nextLine().split(" ");
			long[] finger=obj.strtoint(line1);
			String[] line2=in.nextLine().split(" ");
			long[] sheath=obj.strtoint(line2);
			int j=0;
			boolean front=false;
			boolean back=false;
//			System.out.println(nFinger);
			for(j=0;j<nFinger;j++) {
				
				if(sheath[j]-finger[j]>=0&&front==false) {
					
				}
				else
					front=true;
//				System.out.println("test");
				if(sheath[nFinger-j-1]-finger[j]>=0&&back==false) {
					
				}
				else
					back=true;			
				
			}
			
			
			if(front==false || back==false) {
				if(front==false && back==false) {
//					System.out.println("both");
					outStr[i]="both";
				}
				else if(front==false) {
//					System.out.println("front");
					outStr[i]="front";
				}
				else {
//					System.out.println("back");
					outStr[i]="back";
				}
					
			}
			else {
//				System.out.println("none");
				outStr[i]="none";
			}
			
		}
		
		for(int z=0;z<nCases;z++) {
			out.println(outStr[z]);
		}
		out.close();
	}
	public long[] strtoint(String arr[]){
		int len=arr.length;
		long arrint[]=new long[len];
		int i=0;
		for(i=0;i<len;i++) {
			arrint[i]=Long.parseLong(arr[i]);
		}
		return arrint;
	}
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
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