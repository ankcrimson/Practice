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

public class Euler13 {

	public static String add(String a,String b)
	{
		String ans="";
		char zero='0';
		char[] arra=a.toCharArray();
		char[] arrb=b.toCharArray();
		
		int lena=arra.length;
		int lenb=arrb.length;
		int cry=0;
		for(int i=0;i<lena||i<lenb;i++)
		{
			int x=(lena-i-1>=0)?arra[lena-i-1]-zero:0;
			int y=(lenb-i-1>=0)?arrb[lenb-i-1]-zero:0;
			
			int cdigit=x+y+cry;
			ans=(cdigit%10)+ans;
			cry=cdigit/10;
		}
		if(cry>0)
			ans=cry+ans;
		//System.out.println(cry);
		//System.out.println(ans);
		
		return ans;
	}
	 public static void main(String[] args) throws Exception {
		 
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int t=Integer.parseInt(br.readLine());
		 String sum="0";
		 for(int i=1;i<=t;i++)
		 {
			String curr=br.readLine();
			sum=add(sum,curr);
		 }
		 System.out.println(sum.substring(0, 10));
	}
}
