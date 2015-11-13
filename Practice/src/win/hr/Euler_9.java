package win.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Euler_9 {

	 /*public static void main(String[] args) throws Exception {
		 Map<Integer,Long> map=new HashMap<Integer,Long>();
		 for(int l=3000;l>=2;l--)
		 {
			 for(int h=l-2;h>=2;h--)
			 {
				 for(int p=h-1;p>=1;p--)
				 {
					 int b=l-h-p;
					 if(b>p||b<1)break;
					 if(h*h==p*p+b*b)
					 {
						 //System.out.println(l+" => "+p+","+b+","+h);
						 if(map.containsKey(l))
						 {
							 long curr=map.get(new Integer(l));
							 if(h*p*b>curr)
								 map.put(new Integer(l), (long)h*p*b);
						 }
						 else
						 {
							 map.put(new Integer(l), (long)h*p*b);
						 }
					 }
				 }
			 }
		 }
		 	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			long t=Long.parseLong(br.readLine());
			
			for(long l=0;l<=t;l++)
			{
				Long ans=map.get(Integer.parseInt(br.readLine()));
				//Long ans=map.get(l);
				if(ans==null)
					ans=-1l;
				System.out.println(ans);
			}
	 }
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long t=Long.parseLong(br.readLine());
		Map<Integer,Long> map=new HashMap<Integer,Long>();
		for(int n=0;n<=3000;n++)
		{
			//int n=Integer.parseInt(br.readLine());
			for(int b=1;b<n;b++)
			{
				int p=(n*n-2*b*n);
				int den=(2*(n-b));
				if(p%den==0)
				{
					p=p/den;
					int h=n-p-b;
					
				
				if(map.containsKey(new Integer(n)))
				 {
					 long curr=map.get(new Integer(n));
					 if(h*p*b>curr&&h>0&&p>0&&b>0)
						 map.put(new Integer(n), (long)h*p*b);
				 }
				 else
				 {
					 if(h>0&&p>0&&b>0)
					 map.put(new Integer(n), (long)h*p*b);
				 }
				}
			}
		}
		for(long l=1;l<=t;l++)
		{
			Long ans=map.get(Integer.parseInt(br.readLine()));
			//Long ans=map.get(l);
			if(ans==null)
				ans=-1l;
			System.out.println(ans);
		}
		//System.out.println(map);
	}
}
