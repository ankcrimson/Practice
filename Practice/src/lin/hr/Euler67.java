package lin.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Euler67 {

	 public static void main(String[] args) throws Exception {
		 
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int t=Integer.parseInt(br.readLine());
		 for(int i=1;i<=t;i++)
		 {
			 int n=Integer.parseInt(br.readLine());
			 int[][] vals=new int[n][];
			 for(int j=1;j<=n;j++)
			 {
				 String row=br.readLine();
				 String[] svals=row.split(" ");
				 int[] tvals=new int[j];
				 for(int k=0;k<svals.length;k++)
				 {
					 tvals[k]=Integer.parseInt(svals[k]);
				 }
				 vals[j-1]=tvals;
			 }
			 for(int j=n-1;j>0;j--)
			 {
				 for(int k=1;k<vals[j].length;k++)
				 {
					 int a=(vals[j][k-1]>vals[j][k])?vals[j][k-1]:vals[j][k];
					 if(k-1<vals[j-1].length)
					 vals[j-1][k-1]+=a;
				 }
			 }
			 System.out.println(vals[0][0]);
			 
		 }
		 
	}
}
