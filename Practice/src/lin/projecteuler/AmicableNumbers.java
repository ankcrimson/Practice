package lin.projecteuler;

import java.util.*;

public class AmicableNumbers {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> p1=new HashMap<Integer, Integer>();
		long ans=0;
		for(int i=2;i<10000;i++)
		{
			long sum=0;
			for(int j=1;j<i;j++)
			{
				if(i%j==0)
				{
					sum+=j;
				}
			}
				p1.put((int)sum, i);
			if(p1.containsKey(i)&&p1.get(i)==sum&&i!=sum)
				{
				/*System.out.println(i+","+sum);
				ans+=getson(i);
				ans+=getson((int)sum);*/
				ans+=sum;
				ans+=i;
				System.out.println(i+","+sum);
				}
		}
System.out.println(ans);
	}
public static int getson(int num)
{
int son=0;
while(num>0)
{
son+=num%10;
num/=10;
}
return son;
}
}
