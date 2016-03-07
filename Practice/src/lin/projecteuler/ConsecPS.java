package lin.projecteuler;

import java.util.*;

public class ConsecPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> primes=new ArrayList<Integer>();
		for(int i=2;i<1000000;i++)
		{
			double sqrt=Math.sqrt(i);
			boolean found=false;
			for(int p:primes)
			{
				if(p>sqrt)break;
				if(i%p==0)
				{
					found=true;
					break;
				}
			}
			if(!found)
				primes.add(i);
		}
		Integer[] parr=primes.toArray(new Integer[primes.size()]);
		for(int i=0;i<primes.size();i++)
			parr[i]=primes.get(i);
		int maxS=0;
		int maxP=0;
		for(int i=0;i<primes.size();i++)
		{
			int s=1;
			int p=primes.get(i);
			int sum=primes.get(i);
			for(int j=i+1;j<parr.length;j++)
			{
				sum+=parr[j];
				s++;
				if(sum>1000000)break;
				if(Arrays.binarySearch(parr, sum)>=0)
				{
					p=sum;
					
					if(s>maxS)
					{
						maxS=s;
						maxP=p;
						System.err.println(maxS+","+maxP);
					}
//					else
//						{
//						i=j;
//						break;
//						
//						}
				}
				
			}
		}
	System.out.println(maxS+","+maxP);
	}
	

}
