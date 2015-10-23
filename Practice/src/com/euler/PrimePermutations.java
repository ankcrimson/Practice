package com.euler;

import java.util.LinkedList;
import java.util.List;

public class PrimePermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> primes=new LinkedList<Integer>();
		List<Integer> fourdigprimes=new LinkedList<Integer>();
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
					fourdigprimes.add(i);
			}
		}
		System.out.println(fourdigprimes.size());
	
		//get permutations
		
	}
	public static void getPermutations(String curr,String num)
	{
		String[] chs=num.split("");
		for(String s:chs)
		{
			
		}
	}
}
