package lin.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

public class Euler19 {

	public static String solve(String a, String b)
	{
		String[] startDate=a.split(" ");
		 String[] endDate=b.split(" ");
		 //logic starts
		 long sy=Long.parseLong(startDate[0]);
		 long ey=Long.parseLong(endDate[0]);
		 int sm=Integer.parseInt(startDate[1]);
		 int em=Integer.parseInt(endDate[1]);
		 int sd=Integer.parseInt(startDate[2]);
		 int ed=Integer.parseInt(endDate[2]);
		 
		 long noda=0;
		 long yt=1900;
		 
		 long diff=sy-yt;
		 diff/=400;
		 diff*=400;
		 yt+=diff;
		 
		 
		 int ans=0;
		 while(yt<sy)
		 {
			 if(yt%100!=0&&yt%4==0||yt%400==0)
				 noda+=366;
			 else
				 noda+=365;
			 yt++;
			 //System.out.println(noda);
		 }
		 long tmp=noda;//days till 1 jan SY
		 
		 int mt=1;
		 while(yt<ey||yt==ey&&mt<=em)
		 {
			// System.out.println("mt:"+mt+"noda:"+noda);
			 if(noda%7==6&&(yt<ey||yt==ey&&mt<=em))
			 {
			//	System.out.println(yt+" / "+mt);
				 ans++;
			 }
			 switch(mt)
			 {
			 case 1:
			 case 3:
			 case 5:
			 case 7:
			 case 8:
			 case 10:noda+=31;mt++;break;
			 case 12:noda+=31;yt++;mt=1;break;
			 case 2: noda+=(yt%100!=0&&yt%4==0||yt%400==0)?29:28;mt++;break;
			 default: noda+=30;mt++;
			 }
			 
		 }
		 
		 return ans+"";
	}
	
	 public static void main(String[] args) throws Exception {
		 
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int t=Integer.parseInt(br.readLine());
		 for(int i=1;i<=t;i++)
		 {
			 String a=br.readLine();
			 String b=br.readLine();
			 System.out.println(solve(a, b));
		 }
		 
	}
	 
	 @Test
	 public void unitTests()
	 {
		 Assert.assertEquals("2", solve("1900 1 1", "1901 1 1"));
		 System.out.println("-----------------------");
		 Assert.assertEquals("1", solve("1900 4 1", "1900 4 1"));
		 System.out.println("-----------------------");
		 Assert.assertEquals("18", solve("1900 1 1", "1910 1 1"));
		 System.out.println("-----------------------");
		 Assert.assertEquals("35", solve("2000 1 1", "2020 1 1"));
		 System.out.println("-----------------------");
		 Assert.assertEquals("2", solve("2015 2 1", "2015 3 1"));
		 System.out.println("-----------------------");
		 Assert.assertEquals("171", solve("1901 1 1", "2000 12 31"));
		 System.out.println("-----------------------");
		 Assert.assertEquals("171", solve("9999999999992701 1 1", "9999999999992800 12 31"));
		 
	 }
}
