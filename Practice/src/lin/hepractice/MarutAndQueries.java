package lin.hepractice;

import java.io.*;
import java.util.*;
public class MarutAndQueries {

	 public static void main(String args[] ) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        br.readLine();
	        String[] arr1=br.readLine().split(" ");//Arr 1
	        int n=arr1.length;
	        //int[] a1=new int[n];
	        ArrayList<Integer> a11=new ArrayList<Integer>();
			for(int c=0;c<n;c++)
			{
				//int i=0;
				int tmp=Integer.parseInt(arr1[c]);
				boolean added=false;
				for(int i=0;i<a11.size();i++)
				if(a11.size()>i+1&&a11.get(i+1)>tmp)
				{
					a11.add(i+1, tmp);
					added=true;
					break;
				}
				if(!added)
				a11.add(tmp);
			}
			
			//Arrays.sort(a1);
			
	        String qStr=br.readLine();//Q
	        int q = Integer.parseInt(qStr);
	        for (int i = 0; i < q; i++) {
	            //System.out.println("hello world");
	            String[] kx=br.readLine().split(" ");//k and x
	            int k=Integer.parseInt(kx[0]);
	            int x=Integer.parseInt(kx[1]);
	        	k--;
	        	x--;
	        	while(k<n-1&&a11.get(k)==a11.get(k+1))
	        	k++;
	        	
	        	System.out.println(x-k);
	       		 
	        }
	       
	    }

}
