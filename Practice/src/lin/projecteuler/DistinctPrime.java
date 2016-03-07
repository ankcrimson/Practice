package lin.projecteuler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DistinctPrime {
	static public int getDP(List<Integer> primes, int num)
	{
		int dp=0;
		
		for(int p:primes)
		{
			
			if(num%p==0)
				{
				num/=p;
				dp++;
				}
			if(p*p>num){dp++;break;}
			
		}
		
		return dp;
	}
public static void main(String[] args) {
	Date start=new Date();
	List<Integer> primes=new ArrayList<Integer>();
	for(int i=2;i<1000;i++)
	{
		boolean found=false;
		for(int p:primes)
		{
			if(i%p==0)
			{
				found=true;
				break;
			}
		}
		if(!found)
			primes.add(i);
	}
	for(int i=2;i<2000000;i++)
	{
		if(getDP(primes, i)==4)
			if(getDP(primes, i+1)==4)
				if(getDP(primes, i+2)==4)
					if(getDP(primes, i+3)==4)
						{
						System.out.println(i);
						break;
						}
					else
					i+=3;
				else
				i+=2;
			else
				i++;
	}
	Date end=new Date();
	System.out.println("time="+(end.getTime()-start.getTime())+" ms");
}
}
