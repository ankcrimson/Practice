package lin.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class Euler16 {

	@Test
	public void probTester()
	{
		BigInteger two=new BigInteger("2");
		Assert.assertEquals(1, solve(two, 0));
		Assert.assertEquals(2, solve(two, 1));
		Assert.assertEquals(4, solve(two, 2));
		Assert.assertEquals(8, solve(two, 3));
		Assert.assertEquals(7, solve(two, 4));
		Assert.assertEquals(5, solve(two, 5));
		Assert.assertEquals(10, solve(two, 6));
		
	}
	
	
	public long solve(BigInteger two, int curr)
	{
		BigInteger pow=two.pow(curr);
		
		char[] num=pow.toString().toCharArray();
		long ans=0;
		for(char ch:num)
		{
			ans+=ch-'0';
		}
		return ans;
	}
	 public static void main(String[] args) throws Exception {
		Euler16 obj=new Euler16();
		BigInteger two=new BigInteger("2");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++)
		{
			int curr=Integer.parseInt(br.readLine());
			
			System.out.println(obj.solve(two, curr));
		}
		 
	}
	 
}
