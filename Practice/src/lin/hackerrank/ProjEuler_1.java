package lin.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProjEuler_1 {

	public static void main(String[] args) throws Exception {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	long t=Long.parseLong(br.readLine());
	for(long i=0;i<t;i++)
	{
		long num=Long.parseLong(br.readLine());
		long s3=0;
		long s5=0;
		long s15=0;
		if(num%3==0)
			s3=num/3-1;
		else
			s3=num/3;
		
		s3=(s3*(s3+1)/2)*3;
		
		if(num%5==0)
			s5=num/5-1;
		else
			s5=num/5;
		
		s5=(s5*(s5+1)/2)*5;
		
		if(num%15==0)
			s15=num/15-1;
		else
			s15=num/15;
		
		s15=(s15*(s15+1)/2)*15;
		
		System.out.println(s3+s5-s15);
	}
	}

}
