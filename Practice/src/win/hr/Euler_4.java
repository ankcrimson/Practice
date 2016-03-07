package win.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Euler_4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long t=Long.parseLong(br.readLine());
		List<Long> nums=new LinkedList<Long>();
		for(int i=100;i<1000;i++)
			for(int j=100;j<1000;j++)
			{
				long mul=i*j;
				String str=mul+"";
				StringBuffer sb=new StringBuffer(str).reverse();
				if(str.equals(sb.toString())&&str.length()==6)
				{
					nums.add(mul);
				}
			}
		//System.out.println("starting");
		//System.out.println(nums);
		Long[] numsa=new Long[nums.size()];
		Arrays.sort(nums.toArray(numsa));
		for(long i=0;i<t;i++)
		{
			long curr=Long.parseLong(br.readLine());
			long ans=0;
			for(long num:numsa)
			{
				if(num>curr)
					break;
				ans=num;
			}
			System.out.println(ans);
		}
	}
}
