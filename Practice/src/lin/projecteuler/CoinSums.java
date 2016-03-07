package lin.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class CoinSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tgt=200;
		List<Integer> nos=new ArrayList<Integer>();
		nos.add(200);
		nos.add(100);
		nos.add(50);
		nos.add(20);
		nos.add(10);
		nos.add(5);
		nos.add(2);
		nos.add(1);
		int nums[]=new int[201];
		nums[0]=1;
		for(int n:nos)
		for(int i=0;i<201;i++)
		{
			if(i-n>=0)
			nums[i]+=nums[i-n];
			
		}
		for(int i=0;i<10;i++)
			System.out.println(i+","+nums[i]);
	}

}
