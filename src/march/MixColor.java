package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MixColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		MixColorInputReader in=new MixColorInputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);

	}

}

class Node{
	int num;
	Node left;
	Node right;
	public Node(int num) {
		this.num=num;
		left=null;
		right=null;
	}
}

class BST{
	
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