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
/*
LONG: 9223372036854775807 (19 chars)
INTEGER: 2147483647 (10 chars)
SHORT: 32767 (5 chars)
BYTE: 127 (3 chars) 
 */

public class Euler20 {

	public static void solve(int[] results)
	{
		results[1]=results[0]=1;
		results[2]=2;
		BigInteger bi=new BigInteger("2");
		for(int i=3;i<=1001;i++)
		{
			BigInteger mul=new BigInteger(""+i);
			bi=bi.multiply(mul);
			char[] chars=bi.toString().toCharArray();
			int res=0;
			for(char ch:chars)
				res+=ch-'0';
			results[i]=res;
			
		}
	}
	 public static void main(String[] args) throws Exception {
		 int[] cache=new int[10001];
		 solve(cache);
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int t=Integer.parseInt(br.readLine());
		 for(int i=1;i<=t;i++)
		 {
			 int curr=Integer.parseInt(br.readLine());
			 System.out.println(cache[curr]);
			 
		 }
		 
	}
	 @Test
	 public void test()
	 {
		 int[] cache=new int[10001];
		 solve(cache);
		 Assert.assertEquals(6, cache[3]);
		 Assert.assertEquals(9, cache[6]);
	 }
}
