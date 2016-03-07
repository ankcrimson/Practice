package lin.projecteuler;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimePermuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> primes=new ArrayList<Integer>();
		List<Integer> fourdigPms=new ArrayList<Integer>();
		for(int i=2;i<10000;i++)
		{
			boolean found=false;
			for(int p:primes)
			{
				if(i%p==0)
				{
					found=true;
					break;
				}
			}
			if(!found)
				{
				primes.add(i);
				if(i>999&&i<10000)
					{
					fourdigPms.add(i);
				}
		}
	
		}
		for(int i=0;i<fourdigPms.size();i++)
		{
			for(int j=i+1;j<fourdigPms.size();j++)
			{
				int diff=fourdigPms.get(j)-fourdigPms.get(i);
				if(fourdigPms.contains(fourdigPms.get(j)+diff))
				{
					//if(getSorted(fourdigPms.get(i)+"").equals(getSorted(fourdigPms.get(j)+""))&&getSorted(fourdigPms.get(j)+"").equals((fourdigPms.get(j)+diff)+""))
					int a=fourdigPms.get(i);
					int b=fourdigPms.get(j);
					int c=fourdigPms.get(j)+diff;
					if(getSorted(a+"").equals(getSorted(b+""))&&getSorted(b+"").equals(getSorted(c+"")))
					System.out.println(fourdigPms.get(i)+""+fourdigPms.get(j)+""+(fourdigPms.get(j)+diff));
				}
			}
		}
		
	}
	public static String getSorted(String s)
	{
		byte[] bts=s.getBytes();
		Arrays.sort(bts);
		return new String(bts);
	}
}
