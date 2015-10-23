package win.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Euler_6 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long t=Long.parseLong(br.readLine());
		
		for(long i=0;i<t;i++)
		{
			long curr=Long.parseLong(br.readLine());
			long sumSq=0;
			long sqsum=0;
			long sum=0;
			for(long j=0;j<=curr;j++)
			{
				sqsum+=j*j;
				sum+=j;
			}
			sumSq=sum*sum;
			System.out.println(sumSq-sqsum);
		}
	}
}
