package lin.projecteuler;

import java.util.LinkedList;
import java.util.List;

public class Pentagonal {
public static void main(String[] args) {
	List<Long> pgs=new LinkedList<Long>();
	long min=Long.MAX_VALUE;
	for(int i=1;i<10000;i++)
	{
		long num=((3*i-1)*i)/2;
		pgs.add(num);
		//System.err.println(i);
	}
	for(int i=0;i<5000;i++)
	{
		long num=pgs.get(i);
		for(int j=i+1;j<5000;j++){
			long l=pgs.get(j);
			if(num==l)continue;
		long sum=l+num;
		long diff=l-num;
		if(diff<0)diff=diff*-1;
		if(pgs.contains(sum)&&pgs.contains(diff))
		{
			if(min>diff){
				min=diff;
			}
			System.out.println(l+","+num+", diff="+min);
		}	
		}
		
	}
	
}
}
