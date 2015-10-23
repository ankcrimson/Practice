package lin.projecteuler;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PermutedMuls {

	public void addBytes(Set<Byte> set, byte[] bytes)
	{
		for(byte b:bytes)
			set.add(b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutedMuls pm=new PermutedMuls();
		int lim=Integer.MAX_VALUE/6;
		boolean found=false;
		for(int i=1;i<lim;i++)
		{
			
			byte[] a=(i+"").getBytes();
			Set<Byte> ab=new HashSet<Byte>();
			pm.addBytes(ab, a);
			for(int j=2;j<=6;j++)
			{
				byte[] b=((i*j)+"").getBytes();
				Set<Byte> bb=new HashSet<Byte>();
				pm.addBytes(bb, b);
				if(!ab.containsAll(bb))
					break;
				if(ab.containsAll(bb)&&j==6)
					found=true;
			}
			if(found)
			{
				System.out.println(i);
				break;
			}
		}
	}

}
