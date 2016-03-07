package lin.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class DigitCancellingFractions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> primes=new ArrayList<Integer>();
		for(int i=2;i<100;i++)
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
		
		
		int nr=1;
		int dr=1;
		
		for(int i=1;i<10;i++)
		{
			for(int j=1;j<10;j++)
			{
				for(int k=1;k<10;k++)
				{
					int n=i*10+j;
					int d1=j*10+k;
					int d2=k*10+j;
					
					
					
					int x1=n;
					int y1=d1;
					
					int x2=n;
					int y2=d2;
					
					int xf=i;
					int yf=k;
					
					for(int l=0;l<primes.size();l++)
					{
						if(x1%primes.get(l)==0&&y1%primes.get(l)==0)
						{x1/=primes.get(l);y1/=primes.get(l);l--;
						continue;
						}
					}
					
					for(int l=0;l<primes.size();l++)
					{
						if(x2%primes.get(l)==0&&y2%primes.get(l)==0)
						{x2/=primes.get(l);y2/=primes.get(l);l--;
						continue;
						}
					}
					
					for(int l=0;l<primes.size();l++)
					{
						if(xf%primes.get(l)==0&&yf%primes.get(l)==0)
						{xf/=primes.get(l);yf/=primes.get(l);l--;
						continue;
						}
					}
					
					
					if(x1==xf&&y1==yf&&n!=d1)
						{
						//System.out.println(x1+"/"+y1);
						nr*=x1;
						dr*=y1;
						}
					if(x2==xf&&y2==yf&&n!=d2)
						{
						nr*=x2;
						dr*=y2;
						//System.out.println(x2+"/"+y2);
						}
					
				}
			}
		}
		for(int l=0;l<primes.size();l++)
		{
			if(nr%primes.get(l)==0&&dr%primes.get(l)==0)
			{nr/=primes.get(l);dr/=primes.get(l);l--;
			continue;
			}
		}
		System.out.println(dr);
	}

}
