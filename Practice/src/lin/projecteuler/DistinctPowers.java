package lin.projecteuler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class DistinctPowers {

	public static void main(String[] args) {
		Set<BigInteger> dists=new HashSet<BigInteger>(); 
		for(int a=2;a<=100;a++)
		{
			BigInteger aval=new BigInteger(a+"");
			for(int b=2;b<=100;b++)
			{
				BigInteger num=new BigInteger(""+a);
				for(int i=0;i<b-1;i++)
				{
					num=num.multiply(aval);
				}
				dists.add(num);
			}	
		}
		
		System.out.println(dists.size());
	}

}
