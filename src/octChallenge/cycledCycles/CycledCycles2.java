package octChallenge.cycledCycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CycledCycles2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream input=System.in;
		InputReader in=new InputReader(input);
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		String[] line1=in.nextLine().split(" ");
		int nCycles=Integer.parseInt(line1[0]);
		int nQuery=Integer.parseInt(line1[1]);
		
		ArrayList<int[][]> cycles=new ArrayList<int[][]>();
		for(int i=0;i<nCycles;i++) {
			String[] singleCycle=in.nextLine().split(" ");
			int nNodes=Integer.parseInt(singleCycle[0]);
			String[] singleCycle2=new String[nNodes];
			for(int j=0;j<nNodes;j++) {
				singleCycle2[j]=singleCycle[j+1];
			}
			int tmp[][]=new int[nNodes][nNodes];
			
			for(int j=0;j<nNodes;j++) {
				int z=0;
				for(int k=j;k<nNodes;k++) {					
					if(j==k)
						tmp[j][k]=0;
					else {
						if(k>0) {
							if(tmp[j][k]!=0&&tmp[j][k]>tmp[j][k-1]+Integer.parseInt(singleCycle2[(j+z+1)%nNodes])) {
								tmp[j][k]=tmp[j][k-1]+Integer.parseInt(singleCycle2[(j+z+1)%nNodes]);
								tmp[k][j]=tmp[k-1][j]+Integer.parseInt(singleCycle2[(j+z+1)%nNodes]);													
							}
							else {
								tmp[j][k]=tmp[j][k-1]+Integer.parseInt(singleCycle2[(j+z+1)%nNodes]);
								tmp[k][j]=tmp[k-1][j]+Integer.parseInt(singleCycle2[(j+z+1)%nNodes]);													

							}							
						}
						else {
							
							tmp[j][k]=Integer.parseInt(singleCycle2[(j+z+1)%nNodes]);
							tmp[k][j]=Integer.parseInt(singleCycle2[(j+z+1)%nNodes]);													
						}
						
						
					}
					z++;

				}
//				break;
			}
			cycles.add(tmp);
		}
		int[][] tmp;
		for(int i=0;i<nCycles;i++) {
			tmp=cycles.get(i);
			for(int j=0;j<tmp.length;j++) {
				for(int k=0;k<tmp.length;k++) {
					out.print(tmp[j][k]);
				}	
				out.println();
			}
		}
		
		out.close();
	}

}
 
