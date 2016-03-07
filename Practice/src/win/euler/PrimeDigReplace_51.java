package win.euler;

import java.util.ArrayList;
import java.util.List;

public class PrimeDigReplace_51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> primes=new ArrayList<Integer>();
		for(int i=2;i<100000;i++)
		{
			boolean fnd=false;
			for(int p:primes){
				if(i%p==0)
				{
					fnd=true;
					break;
				}
			}
			if(!fnd)
			{
				primes.add(i);
			}
		}
		
	}

}
