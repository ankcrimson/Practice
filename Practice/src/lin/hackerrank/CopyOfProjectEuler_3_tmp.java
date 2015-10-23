package lin.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CopyOfProjectEuler_3_tmp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(br.readLine());
        List<Long> primes=new ArrayList<Long>();
        primes.add(2l);
        for( long i=3;i<1000l;i++)
        {
        	 boolean found=false;
  		   for(long p : primes)
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
        
      outer:  for(int i=0;i<n;i++)
            {
        	
          // long curr=Long.parseLong(br.readLine());
          long curr=1000000000000l; 
    	  long max=0;
           
          long sqrt=(long)Math.sqrt(curr);
           sqrt++;
          for(long j=1;j<curr;j++)
          {
        	  if(curr%j==0&&isPrime(j, primes))
        	  {
        		  max=j;
        	  }
          }
          System.out.println(max);
           
	}

	}
static public boolean isPrime(long num,List<Long> primes)
{
long sqrt=(long)Math.sqrt(num)+1;
for(long p:primes)
{
	if(num%p==0)
		return false;
	if(p>sqrt)
		break;
}
return true;
}

}
