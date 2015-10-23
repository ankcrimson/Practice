package com.euler;

public class PrimeFactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long num=600851475143l;
		long sqrt=(long)Math.sqrt((double)num)+1;
		long ans=1;
		for(long i=2;i<sqrt;i++)
		{
			if(num%i==0)
			{
				if(i>ans)
				{
					ans=i;
				}
				num/=i;
				i--;
			}
		}
		System.out.println(ans);
	}

}
