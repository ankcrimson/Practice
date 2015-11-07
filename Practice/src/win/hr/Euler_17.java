
package win.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Euler_17 {
	
	public static String printTwoDigit(long td)
	{
		String ans="";
		if(td>=20)
		{
			switch((int)td/10)
			{
			case 2:ans+=("Twenty ");break;
			case 3:ans+=("Thirty ");break;
			case 4:ans+=("Forty ");break;
			case 5:ans+=("Fifty ");break;
			case 6:ans+=("Sixty ");break;
			case 7:ans+=("Seventy ");break;
			case 8:ans+=("Eighty ");break;
			case 9:ans+=("Ninety ");break;
			}
			td=td%10;
		}
		switch((int)td)
		{
		case 1: ans+=("One");break;
		case 2: ans+=("Two");break;
		case 3: ans+=("Three");break;
		case 4: ans+=("Four");break;
		case 5: ans+=("Five");break;
		case 6: ans+=("Six");break;
		case 7: ans+=("Seven");break;
		case 8: ans+=("Eight");break;
		case 9: ans+=("Nine");break;
		case 10: ans+=("Ten");break;
		case 11: ans+=("Eleven");break;
		case 12: ans+=("Twelve");break;
		case 13: ans+=("Thirteen");break;
		case 14: ans+=("Fourteen");break;
		case 15: ans+=("Fifteen");break;
		case 16: ans+=("Sixteen");break;
		case 17: ans+=("Seventeen");break;
		case 18: ans+=("Eighteen");break;
		case 19: ans+=("Nineteen");break;
		}
		return ans;
	}
	
	public static String printNum(long i)//less than thousand
	{
		String ans="";
		if(i>=100)
		{
			ans+=printTwoDigit(i/100);
			i=i%100;
			ans+=(" Hundred ");
		}
		ans+=printTwoDigit(i);
		return ans;
	}
	
	public static void main(String[] args) {
	
		try(
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			)
	{
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++)
		{
			String ans="";
			long curr=Long.parseLong(br.readLine());
			
			if(curr>=1000000000000l)//billion
			{
				ans+=printNum(curr/1000000000000l);
				ans+=(" Trillion ");
				curr=curr%1000000000000l;
			}
			
			
			if(curr>=1000000000l)//billion
			{
				ans+=printNum(curr/1000000000l);
				ans+=(" Billion ");
				curr=curr%1000000000l;
			}
			if(curr>=1000000l)//Million
			{
				ans+=printNum(curr/1000000l);
				ans+=(" Million ");
				curr=curr%1000000l;
			}
			if(curr>=1000l)//Thousand
			{
				ans+=printNum(curr/1000l);
				ans+=(" Thousand ");
				curr=curr%1000l;
			}
			ans+=printNum(curr);
			if(ans.length()==0)
				System.out.println("Zero");
			else
				System.out.println(ans.trim().replaceAll("  ", " "));
		}
	}catch(Exception ex){ex.printStackTrace();}
}
}
