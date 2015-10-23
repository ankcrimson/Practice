package win.euler;

import java.util.ArrayList;
import java.util.List;

public class SumOfPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long lim=2000000;
		long sum=0;
		List<Long> primes=new ArrayList<Long>(); 
		outer: for(long i=2;i<lim;i++)
		{
			long sqrt=(long)Math.sqrt(i);
			for(long l:primes)
			{
				if(l>sqrt)
					break;
				if(i%l==0)
					continue outer;
			}
			//System.out.println(i);
			primes.add(i);
		sum+=i;
		}
		
		System.out.println(sum);
	}

}
