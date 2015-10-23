package com.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Euler_7 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long t=Long.parseLong(br.readLine());
		
		List<Long> primes=new LinkedList<Long>();
		primes.add(2l);
		outer: for(long i=3;primes.size()<10000;i++)
		{
			long sqrt=(long)Math.sqrt(i);
			for(long p:primes)
			{
				if(i%p==0)
					continue outer;
				if(p>sqrt)
					break;
			}
			primes.add(i);
		}
		//System.out.println(primes);
		for(long i=0;i<t;i++)
		{
			int curr=Integer.parseInt(br.readLine());
			System.out.println(primes.get(curr-1));
		}
	}
}
