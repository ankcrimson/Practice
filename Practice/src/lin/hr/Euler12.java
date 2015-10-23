package lin.hr;
//with guidance from http://www.mathblog.dk/triangle-number-with-more-than-500-divisors/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Euler12 {
	public static int getNoOfFacts(int n,List<Integer> primes)
	{
		if(n==1)
			return 1;
		
		int nod=1;
		
		int exp;
		int rem=n;
		for(int p:primes)
		{
			if(p*p>n)
				return nod*2;
			
			exp=1;
			while(rem%p==0)
			{
				rem/=p;
				exp++;
			}
			
			nod*=exp;
			if(rem==1)
				return nod;
		}
		
		return nod;
	}
	
public static void main(String[] args) throws Exception{
	List<Integer> primes=new LinkedList<Integer>();
	primes.add(2);
	outer: for(int i=3;i<10000;i++){
		for(int p:primes)
		{
			if(i%p==0)
				continue outer;
			if(p*p>i)
				break;
		}
		primes.add(i);
	}
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(br.readLine());
	for(int i=0;i<t;i++)
	{
		int n=Integer.parseInt(br.readLine());
		int j=2;
		int num=1;
		while(getNoOfFacts(num,primes)<=n)
		{
			//System.out.println(num+" => "+getNoOfFacts(num,primes));
			num=num+j;
			j++;
		}
		System.out.println(num);
	}
	br.close();
}

}
