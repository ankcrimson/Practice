package com.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Euler_5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long t=Long.parseLong(br.readLine());
		List<Long> primes=new LinkedList<Long>();
		primes.add(2l);
		outer: for(long j=3;j<=40;j++)
		{
			for(long p:primes)
			{
				if(j%p==0)
					continue outer;
			}
			primes.add(j);
		}
		
		for(long i=0;i<t;i++)
		{
			long curr=Long.parseLong(br.readLine());
			List<Long> factors=new ArrayList<Long>();
			for(long j=2;j<=curr;j++)
			{
				long tmp=j;
				List<Long> jfact=new ArrayList<Long>();
				for(long p:primes)
				{
					while(tmp%p==0)
					{
						jfact.add(p);
						tmp=tmp/p;
					}
					if(p>tmp)
						break;
				}
				//System.out.println(j+" : "+jfact);
				List<Long> tmpFact=new ArrayList<Long>();
				tmpFact.addAll(factors);
				
				//if(factors.containsAll(jfact))
				//	continue;
				boolean broken=false;
				for(long jf:jfact)
				{
					int ind=tmpFact.indexOf(jf);
					if(ind<0){
						broken=true;
						break;
					}
					tmpFact.remove(ind);
				}
				if(!broken)
					continue;
				
				for(long jf:jfact)
				{
					int ind=factors.indexOf(jf);
					if(ind>=0)
					factors.remove(ind);
				}
				for(long jf:jfact)
				{
					factors.add(jf);
				}
			}
			long ans=1;
			for(long f:factors)
				ans*=f;
			//System.out.println(factors);
			System.out.println(ans);
		}
	}
}
