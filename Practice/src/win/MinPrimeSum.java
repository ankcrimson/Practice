package win;
import java.util.ArrayList;
import java.util.List;


public class MinPrimeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long lim=1000000000000l;
		//long lim=100l;
		long plim=10000000;
		long sum=2;
		List<Long> pms=new ArrayList<Long>();
		
		for(long i=3;i<=lim;i+=2)
		{
			boolean fnd=false;
			long curr=0;
			for(long p:pms)
			{
				if(p>plim)
					break;
				if(i%p==0)
				{
					fnd=true;
					curr=p;
					break;
				}
			}
			if(!fnd)
			{
				curr=i;
				if(i<1000000)
				pms.add(i);
			}
			sum+=curr+2;
			if(sum>1000000000l)
				sum-=1000000000l;
			//System.out.println(i);
		}
		System.out.println(sum);
	}

}
