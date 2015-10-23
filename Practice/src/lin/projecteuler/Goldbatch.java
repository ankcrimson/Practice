package lin.projecteuler;

import java.util.LinkedList;
import java.util.List;

public class Goldbatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> primes=new LinkedList<Integer>();
		for(int i=2;i<Integer.MAX_VALUE;i++)
		{
			boolean found=false;
			for(int pm:primes)
			{
				if(i%pm==0)
				{
					found=true;
					break;
				}
			}
			if(!found)
				primes.add(i);
			else if(i%2!=0)//odd composite number
			{
				boolean satisfy=false;
				for(int pm:primes)
				{
					double x=Math.sqrt((i-pm)/2);
				if(Math.ceil(x)==Math.floor(x))
					{
					satisfy=true;
					break;
					}
				}
				if(!satisfy){
					System.out.println(i);
					break;
				}
					
			}
				
			
		}
	}

}
