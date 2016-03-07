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

public class Euler14 {

	 public static void main(String[] args) throws Exception {
		 
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int t=Integer.parseInt(br.readLine());
		 for(int i=1;i<=t;i++)
		 {
			 int curr=Integer.parseInt(br.readLine());
			 int len=1;
			 long tmp=curr;
			 while(tmp!=1)
			 {
				 if(tmp%2==0)
					 tmp/=2;
				 else
					 tmp=(tmp*3+1);
				 len++;
			 }
			 System.out.println(len);	 
		 }
		 
	}
}
