package lin.projecteuler;

import java.util.*;

public class SpiralPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> primes=new LinkedList<Integer>();
		for(int i=2;i<=100000;i++)
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
		//for(int p:primes)
		//System.err.println(p);
		int curr=1;
		int pms=0;
		int npms=1;//for 1
		int inc=2;
		for(int i=1;i<=100000;i++)
		{
			for(int j=0;j<4;j++)
			{
			curr+=inc;
			
			boolean prime=true;
			for(int p:primes)
			{
				if(p<curr&&curr%p==0)
				{
					prime=false;
					break;
				}
			}
			
			if(prime)
				pms++;
			else
				npms++;
			//System.out.println(curr);
			}
			float prob=(float)pms/(pms+npms);
			if(prob<0.1)
				{
				System.out.println("Ans:"+(i*2+1));
				System.out.println("Explaination: "+pms+"/"+(pms+npms)+"="+prob);
				break;
				}
			inc+=2;
			
		}

	}

}
