package com.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Euler_12 {

	 public static void main(String[] args) throws Exception {
		 
		 List<Long> primes=new LinkedList<Long>();
		 primes.add(2l);
		 outer: for(long i=3;i<100000;i++)
		 {
			 for(long p:primes)
			 {
				 if(i%p==0)
					 continue outer;
				 if(p>Math.sqrt(i))
					 break;
			 }
			 primes.add(i);
		 }
		 
		  //System.out.println(primes);
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int t=Integer.parseInt(br.readLine());
		 for(int i=1;i<=t;i++)
		 {
			 int curr=Integer.parseInt(br.readLine());
			 
			 
		 }
		 
	}
}
