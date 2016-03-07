package win.euler;

import java.util.HashSet;
import java.util.Set;

public class SmallestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] muls=new int[21];
		for(int i=2;i<=20;i++)
		{
			int cnt=0;
			int tmp=i;
			for(int j=2;j<=i;j++)
			{
				
				if(tmp%j==0)
				{
					tmp/=j;
					cnt++;
					if(muls[j]<cnt)
						muls[j]=cnt;
					
					j--;
				
					//System.out.println((j+1)+","+i);
					continue;
				}
				cnt=0;
			}
		}
		long ans=1;
		for(int i=2;i<=20;i++)
		{
			//System.out.println(i+","+muls[i]);
			for(int j=1;j<=muls[i];j++)
				ans*=i;
			
		}
		System.out.println(ans);
	}

}
