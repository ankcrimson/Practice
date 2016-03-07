package lin.projecteuler;

import java.math.BigInteger;
import java.util.Date;

public class SelfPowers {

	public static void usingBigints()
	{
		Date start=new Date();
		BigInteger ans=new BigInteger("0");
		for(int i=1;i<=1000;i++)
		{
			BigInteger tmp=new BigInteger(i+"");
		ans=ans.add(tmp.pow(i));
		}
		BigInteger mod=new BigInteger("10000000000");
		Date end=new Date();
		System.out.println(ans.mod(mod));
		System.err.println(end.getTime()-start.getTime()+" ms");
	}
	
	
	public static void withoutUsingBigints()
	{
		Date start=new Date();
		long ans=0;
		long mod=10000000000l;
		for(int i=1;i<=1000;i++)
		{
			long tmp=1;
			for(int j=1;j<=i;j++)
			{
				tmp*=i;
				tmp=tmp%mod;
			}
			ans+=tmp;
			ans=ans%mod;
		}
		
		Date end=new Date();
		System.out.println(ans);		
		System.err.println(end.getTime()-start.getTime()+" ms");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		usingBigints();
		withoutUsingBigints();
	}

}
