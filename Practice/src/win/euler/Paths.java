package win.euler;

import java.util.ArrayList;
import java.util.List;

public class Paths {
	
public static void main(String[] args) {
	long x=40;
	long y=20;
//rrdd
	List<Long> nums=new ArrayList<Long>();
	List<Long> denoms=new ArrayList<Long>();
	for(long i=x;i>y;i--)
	{
		long z=i;
		for(long j=y;j>1;j--)
		if(!denoms.contains(j))
			if(z%j==0)
			{
				z=z/j;
				denoms.add(j);
				break;
			}
		nums.add(z);
	}
long denom=1;
long nume=1;
	for(long j=y;j>1;j--)
	if(!denoms.contains(j))
	{
		denom*=j;
	}
	for(long n:nums)
		nume*=n;
	System.out.println(nume/denom);
}
}
