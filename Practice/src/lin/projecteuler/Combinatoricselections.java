package lin.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Combinatoricselections {

	public static void sub(List a, List b)
	{
		for(Object o:b)
		{
			a.remove(o);
		}
	}
	
	public static List<Integer> facts(int num,List<Integer> primes)
	{
		List<Integer> factors=new ArrayList<Integer>();
		int i=0;
		while(num>1)
		{
			if(num%primes.get(i)==0)
			{
				factors.add(primes.get(i));
				num/=primes.get(i);
			
			}
			else
				i++;
			
		}
		return factors;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> primes=new ArrayList<Integer>();
		
		for(int i=2;i<99;i++)
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
		
				
		//sub(va,vb);

		int ans=0;
		
		for(int i=22;i<=100;i++)
		{
			List<Integer> va=facts(i, primes);
			for(int k=i-1;k>0;k--)
			{
				va.addAll(facts(k, primes));
			}
			
			for(int j=1;j<=i;j++)
			{
				List<Integer> vn=new ArrayList<Integer>();
				vn.addAll(va);
				
				List<Integer> vr=facts(j, primes);
				for(int k=j-1;k>0;k--)
				{
					vr.addAll(facts(k, primes));
				}
				
				
				List<Integer> vnr=facts(i-j, primes);
				for(int k=i-j-1;k>0;k--)
				{
					vnr.addAll(facts(k, primes));
				}
				
				
				sub(vn, vr);
				sub(vn, vnr);
				//System.out.println(vn);
				long mul=1;
				for(int f:vn)
				{
					mul*=f;
					if(mul>1000000)
					{
						ans++;
						System.out.println(i+","+j);
						break;
					}
					//System.out.println(mul);
				}
			}
		}
		System.out.println(ans);
	}

}
