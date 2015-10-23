package com.euler;

import java.util.HashSet;
import java.util.Set;

public class PandigitalProdSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Long> vals=new HashSet<Long>(); 
		long sum=0;
		for(int i=1;i<10;i++)
		{
			for(int j=1;j<10;j++)
			{
				if(i==j)continue;
				for(int k=1;k<10;k++)
				{
					if(i==k||j==k)continue;
					for(int l=1;l<10;l++)
					{
						if(i==l||j==l||k==l)continue;
						for(int m=1;m<10;m++)
						{
							if(i==m||j==m||k==m||l==m)continue;
						
							
							for(int n=0;n<10;n++)
							{
								if(i==n||j==n||k==n||l==n||m==n)continue;
								int x1=i*100+j*10+k;
								int x2=l*100+m*10+n;
								long prod=x1*x2;
								
								String fin=""+x1+"x"+x2+"="+prod;
								if(check(fin))
									{
									vals.add(prod);
									sum+=prod;
									}
									
							}
							
							int x1=i;
							int x2=j*1000+k*100+l*10+m;
							long prod=x1*x2;
							
							String fin=""+x1+"x"+x2+"="+prod;
							if(check(fin))
							{
								vals.add(prod);
								sum+=prod;
								}
							
							x1=i*10+j;
							x2=k*100+l*10+m;
							prod=x1*x2;
							
							fin=""+x1+"x"+x2+"="+prod;
							if(check(fin))
							{
								vals.add(prod);
								sum+=prod;
							}
						//	System.out.println(""+i+j+" x "+k+l+m);
						//	System.out.println(""+i+" x "+j+k+l+m);
						}
					}
				}
			}
		}
		System.out.println(sum);
		long s2=0;
		for(long p:vals)
			s2+=p;
		System.out.println(s2);
	}
	
	public static boolean check(String s)
	{
		boolean res=true;
		String vals="123456789";
		String[] vls=vals.split("");
		
		if(s.length()!=11)return false;
		
		for(String v:vls)
		{
			if(!s.contains(v))
				res=false;
		}
		if(res)
			System.out.println(s);
		
		return res;
	}

}
