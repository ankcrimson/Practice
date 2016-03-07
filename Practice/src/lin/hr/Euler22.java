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
/*
LONG: 9223372036854775807 (19 chars)
INTEGER: 2147483647 (10 chars)
SHORT: 32767 (5 chars)
BYTE: 127 (3 chars) 
 */

public class Euler22 {

	 public static void main(String[] args) throws Exception {
		 
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int t=Integer.parseInt(br.readLine());
		 String[] names=new String[t];
		 for(int i=0;i<t;i++)
		 {
			 names[i]=br.readLine();
		 }
		 Arrays.sort(names);
		 Map<String,Integer> answers=new HashMap<>();
		 for(int i=0;i<t;i++)
		 {
			 char[] name=names[i].toCharArray();
			 int weight=0;
			 for(char c:name)
			 {
				 weight+=c-'A'+1;
			 }
			 answers.put(names[i], weight*(i+1));
		 }
		 int q=Integer.parseInt(br.readLine());
		 for(int i=0;i<q;i++)
			 System.out.println(answers.get(br.readLine()));
		 //System.out.println(answers);
		 
		 
		 
	}
}
