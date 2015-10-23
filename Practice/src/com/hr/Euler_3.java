package com.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Euler_3 {

	public static void main(String[] args) throws Exception {
		//Date start=new Date();
		List<Long> primes=new LinkedList<Long>();
		primes.add(2l);
		outer: for(long i=3;i<1000000;i++)
		{
			long sqrt=(long)Math.sqrt(i);
			for(long p:primes)
			{
				if(i%p==0)
					continue outer;
				else if(p>sqrt)
					break;
			}
			primes.add(i);
		}
		//Date end=new Date();
		//System.out.println(end.getTime()-start.getTime());
		//System.out.println(primes);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long t=Long.parseLong(br.readLine());
		for(long i=0;i<t;i++)
		{
			long curr=Long.parseLong(br.readLine());
			long max=0;
			long sqrt=(long)Math.sqrt(curr);
			long ans=0;
			for(long p:primes)
			{
				while(curr%p==0)
				{
					curr=curr/p;
					max=p;
				}
				//sqrt=(long)Math.sqrt(curr);
				if(p>sqrt)
					break;
			}
			max=(max>curr)?max:curr;
			System.out.println(max);
		}
	}
}
