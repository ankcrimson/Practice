package lin;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class C1 {
	static int[] primes=new int[100000];
	static int[] primes2=new int[100000];
public static void fillPrimes()
{
	primes[0]=2;
	primes[1]=3;
	primes[2]=5;
	primes[3]=7;
	int j=4;
	for(int i=10;i<100000;i++)
	{
		int plen=primes.length;
		boolean div=false;
		for(int k=0;k<plen;k++)
		{
			if(primes[k]==0)
				break;
			if(i%primes[k]==0)
				{
				div=true;
				break;
				}
		}
		if(!div)
		{
			primes[j++]=i;
		}
	}
}
public static void main(String args[] ) throws Exception {
        
		fillPrimes();
	
	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        long[] arr=new long[27];
        for (int i = 0; i < T; i++) {
            String l2=br.readLine();
            
            byte[] bytes=l2.getBytes();
            for(byte b:bytes)
            	arr[b-97]++;
        
        long ctr=0;
        boolean primeCheck=true;
        for(long j:arr)
        {
        	if(j>0)
        		ctr++;
        	if(j>0&&!isPrime(j))
        	{
        		primeCheck=false;
        		break;
        	}
        }
        if(primeCheck)
        {
        	primeCheck=isPrime(ctr);
        }
        if(primeCheck)
            System.out.println("YES");
        else
        	System.out.println("NO");
    }
}

public static boolean isPrime(long n) {

for(long l:primes)
	if(l==n)
		return true;

    return false;
}

}
