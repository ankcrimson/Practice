package com.euler;

import java.util.ArrayList;
import java.util.List;

public class Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> denoms=new ArrayList<Integer>();
		denoms.add(1);
		denoms.add(2);
		denoms.add(5);
		denoms.add(10);
		denoms.add(20);
		denoms.add(50);
		denoms.add(100);
		denoms.add(200);
		
		int arr[]=new int[201];
		
		arr[0]=1;
		
		for(int d:denoms)
		for(int i=0;i<arr.length;i++)
		{
			if(i-d>=0)
				arr[i]+=arr[i-d];
		}
		
		
		for(int i=0;i<arr.length;i++)
			System.out.println(i+":"+arr[i]);
	}

}
