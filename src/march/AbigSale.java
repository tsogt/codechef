package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class AbigSale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		InputReaderAbigSale in=new InputReaderAbigSale(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		AbigSale obj=new AbigSale(); 
		int nCases=in.nextInt();
		
		for(int i=0;i<nCases;i++) {
			int nRecipe=in.nextInt();
			double loss=0;
			for(int j=0;j<nRecipe;j++) {
				String[] line1=in.nextLine().split(" ");
				double[] recipe=obj.strtoint(line1);
				
				loss+=(recipe[0]-((recipe[0]+recipe[0]*recipe[2]/100)-(recipe[0]+recipe[0]*recipe[2]/100)*recipe[2]/100))*recipe[1];
				
			}
			out.println(loss);									
		}
		out.close();
	}
	public double[] strtoint(String arr[]){
		int len=arr.length;
		double arrint[]=new double[len];
		int i=0;
		for(i=0;i<len;i++) {
			arrint[i]=Double.parseDouble(arr[i]);
		}
		return arrint;
	}
}

class InputReaderAbigSale {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReaderAbigSale(InputStream stream) {
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