package lin.projecteuler;

import java.math.BigInteger;
import java.util.Date;

public class powerfuldigitcounts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date start=new Date();
		int count=0;
		for(int i=1;i<10;i++)//number 1-9
		{
			BigInteger tmp=new BigInteger("1");
			boolean next=true;
			int j=0;
			while(next)
			{
				BigInteger mul=new BigInteger(""+i);
				tmp=tmp.multiply(mul);
				j++;
				if((""+tmp).length()==j){
					count++;
				}
				else
					next=false;
			}
		}
		System.out.println(count);
		Date now=new Date();
		System.out.println("Time Taken:"+(now.getTime()-start.getTime())+" ms");
	}

}
