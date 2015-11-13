package lin.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class QuadPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> primes=new ArrayList<Integer>();
		for(int i=2;i<1000;i++)
		{
			boolean prime=true;
			for(int j:primes)
				{
				if(i%j==0)
				{prime=false;break;}
				}
			if(prime)primes.add(i);
		}
		//System.out.println(primes);
		int nmax=0;
		int ma=0;
		int mb=0;
		for(int a=-999;a<1000;a++)
		{
			for(int b:primes)
			{
				int cnt=0;
				int n=0;
				while(primes.contains((n*n+a*n+b)))
					n++;
				if(n>nmax)
				{
					nmax=n;
					ma=a;
					mb=b;
				}
				n=0;
				while(primes.contains((n*n+a*n-b)))
					n++;
				if(n>nmax)
				{
					nmax=n;
					ma=a;
					mb=-b;
				}
			}
		}
		System.out.println(nmax+","+ma+","+mb);
		System.out.println(ma*mb);
	}

}
