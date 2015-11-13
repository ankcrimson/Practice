package lin.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Euler_3 {

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
        	
           long curr=Long.parseLong(br.readLine());
           long max=0;
           
           
           
           long sqrt=(long)Math.sqrt(curr);
           sqrt++;
           
           
           
           
           for(int j=0;j<primes.size();j++)
           {
        	   long k=primes.get(j);
        	   if(k>sqrt)break;
        	   if(curr%k==0)
        	   {
        		   curr=curr/primes.get(j);
        		   max=primes.get(j);
        		   j--;
        	   }
           }
           curr=(curr>max)?curr:max;
            sqrt=(long)Math.sqrt(curr);
           
           
           
           if(primes.get(primes.size()-1)<sqrt)
           {//add more primes
        	   long cp=primes.get(primes.size()-1);
        	   for(long j=cp+1;j<=sqrt;j++)
        	   {
        		   boolean found=false;
        		   for(long p : primes)
        		   {
        			   if(j%p==0)
        			   {
        				   found=true;
        				   break;
        			   }
        		   }
        		   if(!found)
        			   primes.add(j);
        		   //System.out.println(j);
        	   }
           }
           //work here
           //System.out.println(primes);
          
           
           for(int j=0;j<primes.size();j++)
           {
        	   if(curr%primes.get(j)==0)
        	   {
        		   curr=curr/primes.get(j);
        		   max=primes.get(j);
        		   j--;
        	   }
           }
         if(max<curr)
        	   System.out.println(curr);
           else
        	   System.out.println(max);
           System.out.println(primes);
        }
	}

}
