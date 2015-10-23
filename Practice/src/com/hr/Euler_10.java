package com.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Euler_10 {

	 public static void main(String[] args) throws Exception {
		
		 List<Integer> primes=new LinkedList<Integer>();
		 primes.add(2);
		 outer: for(int i=3;i<1000000;i++)
		 {
			 for(int p:primes)
			 {
				 int sqrt=(int)Math.sqrt(i);
				 if(i%p==0)
					 continue outer;
				 if(p>sqrt)
					 break;
			 }
			 primes.add(i);
		 }
		 
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long t=Long.parseLong(br.readLine());
		
		for(int l=1;l<=t;l++)
		{
			int lim=Integer.parseInt(br.readLine());
			long ans=0;
			for(int p:primes)
			{
				if(p>lim)
					break;
				ans+=p;
			}
			System.out.println(ans);
		}
		//System.out.println(map);
	}
}
