package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UltimateQn {

	public static void main(String[] args) {
		try(InputStreamReader isr=new InputStreamReader(System.in);
				BufferedReader br=new BufferedReader(isr);)
		{
			String qn=br.readLine();
			String[] abc=qn.split(" ");
			int a=Integer.parseInt(abc[0]);
			int b=Integer.parseInt(abc[1]);
			int c=Integer.parseInt(abc[2]);
			if(a*b*c==42)
				System.out.println(a+"*"+b+"*"+c);
			else if(a*b+c==42)
				System.out.println(a+"*"+b+"+"+c);
			else if(a+b*c==42)
				System.out.println(a+"+"+b+"*"+c);
			else if(a+b+c==42)
				System.out.println(a+"+"+b+"+"+c);
			else 
				System.out.println("This is not the ultimate question");
		}catch(Exception ex){}
	}

}
