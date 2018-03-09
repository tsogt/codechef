package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Triangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		TrianglesInputReader in=new TrianglesInputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		String[] line1=in.nextLine().split(" ");
		String[] line2=in.nextLine().split(" ");
		int N=Integer.parseInt(line1[0]);
		int Q=Integer.parseInt(line1[1]);
		String[] line3;
		
		for(int i=0;i<Q;i++) {
			line3=in.nextLine().split(" ");
			
			if(Integer.parseInt(line3[0])==2) {
				
			}
			else {
				
			}
				
		}
	}

}
class TrianglesInputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public TrianglesInputReader(InputStream stream) {
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
