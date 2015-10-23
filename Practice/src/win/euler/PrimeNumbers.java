package win.euler;

import java.util.LinkedList;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Long> primes=new LinkedList<Long>();
		for(long i=2;i<=Long.MAX_VALUE;i++)
		{
			long x=(long)Math.sqrt((long)i);
			boolean div=false;
			for(long l:primes)
			{
				if(i%l==0)
					{
					div=true;
					break;
					}
			}
			if(!div)
				primes.add(i);
		if(primes.size()==10001)
			break;
		}
		System.out.println(primes.get(10000));
	}

}
