package lin.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Euler12 {
public static void main(String[] args) throws Exception{
	LinkedList<Integer> primes=new LinkedList<Integer>();
	primes.add(2);
	outer: for(int i=3;i<100000;i++)
	{
		for(int p:primes)
		{
			if(i%p==0)
			{
				continue outer;
			}
			if(i>Math.sqrt(i))
				break;
		}
		primes.add(i);
	}
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(br.readLine());
	for(int i=0;i<t;i++)
	{
		int n=Integer.parseInt(br.readLine());
		long num=1;
		for(int j=1;;j++)
		{	
			
			int x=j;
			if(x%2==0)x/=2;
			int y=j+1;
			if(y%2==0)y/=2;
			int curr=1;
			int tmp=0;
			for(int k=0;;k++)
			{
				int p=primes.get(k);
				if(x%p==0)
				{
					k--;
					tmp++;
					x/=p;
					continue;
				}
				if(y%p==0)
				{
					k--;
					tmp++;
					y/=p;
					continue;
				}
				//System.out.println("number="+((j*(j+1))/2)+", p>>"+p+", mul="+(tmp+1));
				curr*=(tmp+1);
				tmp=0;
				//if(p>Math.sqrt(x)&&p>Math.sqrt(y))
				if(p>x&&p>y)	
					break;
			}
			System.out.println(">>> "+((j*(j+1))/2)+", "+curr);
			
			if(curr>n){
				num=(j*(j+1))/2;
				System.out.println(num);
				break;
			}
				
		}
	}
	br.close();
}

}
