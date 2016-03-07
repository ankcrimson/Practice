package lin.hepractice;

import java.util.*;
import java.io.*;

public class BeMyFriend {

	  public static void main(String args[] ) throws Exception {
	    	List<Integer> primes=new ArrayList<Integer>();
	    	for(int i=2;i<999;i++)
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
	    		{
	    			primes.add(i);
	    		}
	    	}
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       String hisNum=br.readLine();
	       int hN=Integer.parseInt(hisNum);//his num
	       List<Integer> hisPrimes=new ArrayList<Integer>();
	    	for(int p:primes)
	    	{
	    		if(hN%p==0)
	    		{
	    			hisPrimes.add(p);
	    		}
	    		if(p>hN)
	    		break;
	    	}
	       
	       
	       String line = br.readLine();
	        //int N = Integer.parseInt(line);
	        String[] otherNums=line.split(" ");
	        int ans=0;
	        for (int i = 0; i < otherNums.length; i++) {
	            String iNum=otherNums[i];
	            int iN=Integer.parseInt(iNum);
	            
	            
	            for(int hp:hisPrimes)
	            {
	            	if(iN%hp==0)
	            	{
	            		ans++;
	            		break;
	            	}
	            	if(hp>iN)
	            	break;
	            }
	            
	        }

	        System.out.println(ans);
	    }

}
