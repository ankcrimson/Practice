package com.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Euler_8 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long t=Long.parseLong(br.readLine());
		
		for(long i=0;i<t;i++)
		{
			String[] nk=br.readLine().split(" ");
			//int n=Integer.parseInt(nk[0]);
			int l=Integer.parseInt(nk[1]);
			char[] num=br.readLine().toCharArray();
			long max=0;
			
			for(int j=0;j<num.length;j++)
				{
				long curr=1;
				num[j]-='0';
				if(j>=l)
				{
					//System.out.println((j-l)+" to "+(j-1));
					for(int k=j-l;k<j;k++)
					{
						curr*=(int)num[k];
					}
					if(curr>max)
						max=curr;
				}
				}
			System.out.println(max);
		}
	}
}
