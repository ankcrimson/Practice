package com.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FiveHundredDivisorsTriangleNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Long> primes=new ArrayList<Long>();
		
		for(long a=2;a<Long.MAX_VALUE;a++)
		{
			boolean found=false;
			for(long l:primes)
			{
				if(a%l==0)
				{found=true;break;}
			}
			if(!found)primes.add(a);
			if(primes.size()>500)break;
		}
		System.out.println(primes);
		
		for(int i=1;i<100;i++)
			if(i*(i-1)>=1000)
			{System.out.println(i);break;}
		
		
		long num=0;
		long max=0;
		for(long i=1;i<Long.MAX_VALUE;i++)
		{
			num+=i;
			int cnt=0;
			
			long tmp=num;
			
			for(int j=0;j<primes.size();j++)
			{
				if(tmp%primes.get(j)==0)
				{
					tmp/=primes.get(j);
					cnt++;
					j--;
					continue;
				}
			}
			cnt+=2;//1 and the number itself
			if(cnt>max){max=cnt;System.out.println(max);}
			if(cnt>500)
				{
				System.out.println(i);
				break;
				}
		}
	}

}
