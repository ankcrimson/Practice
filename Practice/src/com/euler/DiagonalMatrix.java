package com.euler;

import java.io.BufferedReader;
import java.io.FileReader;

public class DiagonalMatrix {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("diagonal_matrix.in");
		BufferedReader br=new BufferedReader(fr);
		String data="";
		int[][] nums=new int[20][20];
		int i=0;
		long max=0;
		while((data=br.readLine())!=null)
		{
			String[] d2=data.split(" ");
			for(int j=0;j<d2.length;j++)
			{
				nums[i][j]=Integer.parseInt(d2[j]);
				if(i>=3)
				{
					
					//System.out.println('a');
					long prod=nums[i-3][j]*nums[i-2][j]*nums[i-1][j]*nums[i][j];
					if(prod>max)
						max=prod;
					
				}
				if(j>=3)
				{
					//System.out.println('b');
					long prod=nums[i][j-3]*nums[i][j-2]*nums[i][j-1]*nums[i][j];
					if(prod>max)
						max=prod;
				}
				if(i>=3&&j>=3)
				{
					//System.out.println('c');
					long prod=nums[i-3][j-3]*nums[i-2][j-2]*nums[i-1][j-1]*nums[i][j];
					if(prod>max)
						max=prod;
					
				}
				if(i>=3&&j>=3)
				{
					//System.out.println('d');
					long prod=nums[i][j-3]*nums[i-1][j-2]*nums[i-2][j-1]*nums[i-3][j];
					if(prod>max)
						max=prod;
					
				}
				
				//System.out.print(nums[i][j]+" ");
			}
			i++;
		System.out.println();
		}
		
		
		
		System.out.println(max);
		
	}

}
