package lin.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class LargestFraction {

	public static String calc(int d)
	{
		String q="";
		int n=10;
		int r=0;
		while((n>0||r>0)&&q.length()<=10000)
		{
				r=n%d;
				q+=n/d;
			n=r*10;	
		}
		return q;
	}
	public static List<Byte> findRep(String s)
	{
		List<Byte> pattern=new ArrayList<Byte>();
		byte[] str=s.getBytes();
		pattern.add(str[0]);
		int i=1;
		for(i=1;i<str.length;i++)
		{
			boolean match=true;
			for(int j=0;j<pattern.size();j++)
			{
				if(i+j>10000)break;
				if(pattern.get(j)!=str[i+j])
					{
					match=false;
					break;
					}
			}
			if(match)
			{
				if(pattern.size()>5)
				//System.out.println((s.substring(pattern.size()*3, pattern.size()*4))+"-----"+(s.substring(pattern.size()*4, pattern.size()*4)));
				//if((s.substring(pattern.size()*3, pattern.size()*4)).equals(s.substring(pattern.size()*4, pattern.size()*4)))
				break;
				else
				{
					pattern.add(str[i]);
				}
			}
			else
			pattern.add(str[i]);
		}
		if(pattern.size()>=9000)
		{
			pattern.clear();
			
		}
		return pattern;
	}
	public static void main(String[] args) {
	solve();
	}
	private static void solve() {

        int max = 0;
        int maxSize = 0;
        int d;
        for (d = 2; d < 1000; d++) {

            List<Integer> remainders = new ArrayList<Integer>();
            int v = 1;
            int r = v % d;
            while (!remainders.contains(r)) {
                v = r * 10;
                remainders.add(r);
                r = v % d;
            }
            if (remainders.size() > maxSize) {
                maxSize = remainders.size();
                max = d;
            }

        }

        System.out.println(max);

    }

}
