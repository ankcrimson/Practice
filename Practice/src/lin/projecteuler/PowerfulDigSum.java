package lin.projecteuler;

import java.math.BigInteger;

public class PowerfulDigSum {

	public static int check(BigInteger bi)
	{
		int sum=0;
		BigInteger ten=new BigInteger("10");
		int num=5;
		while(num!=0)
		{
		BigInteger[] sr=bi.divideAndRemainder(ten);
		num=sr[0].intValue();
		sum+=sr[1].intValue();
		bi=bi.divide(ten);
		}
		return sum;
	}
	public static void main(String[] args) {

		int max=0;
		for(int i=2;i<100;i++)
		{
			BigInteger b=new BigInteger(i+"");
			BigInteger tmp=new BigInteger("1");
			for(int j=1;j<=100;j++)
			{
				tmp=tmp.multiply(b);
				int ct=check(tmp);
				if(ct>max)
				{
					max=ct;
					System.out.println(max);
				}
			}
		}

	}

}
