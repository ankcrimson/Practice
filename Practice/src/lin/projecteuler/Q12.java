package lin.projecteuler;

import java.util.*;

public class Q12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		List<Long> primes=new ArrayList<Long>();
		for(long i=2;i<20;i++)
		{
			boolean found=false;
			for(long p:primes)
			{
				if(p>=i)break;
				if(i%p==0)
					{
					found=true;
					break;
					}
			}
			if(!found)primes.add(i);
			
		}
		//System.out.println(primes.size());
		long sum=0;
		long max=0;
		for(long i=1;i<Long.MAX_VALUE;i++)
		{
			sum+=i;
			long tmp=sum;
			long nof=1;
			long cnt=0;
			for(int j=0;j<primes.size();j++)
			{
				if(tmp%primes.get(j)==0)
				{
					cnt++;
					tmp/=primes.get(j);
					j--;
				}
				else
				{
					nof*=cnt+1;
					cnt=0;
				}
					
			}
			if(nof>500)
			{
				long stop = System.currentTimeMillis();
				System.out.println(sum);
				System.out.println(stop-start);
				break;
			}
			
		}
		 
		 
	}

}
