package lin.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Euler_2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long n=Long.parseLong(br.readLine());
        for(int i=0;i<n;i++)
            {
        	
            long curr=Long.parseLong(br.readLine());
            long a=1;
            long b=1;
            long ans=0;
            if(curr<=2)
            	{
            	//System.out.println(0);
            	continue;
            	}
            while(b<curr)
            {
            	if(b%2==0)
            	{
            		System.out.println(">>"+b);
            		ans+=b;
            	}
            	long tmp=b;
            	b=b+a;
            	a=tmp;
            }
            System.out.println(ans);
            
            
        }
	}

}
