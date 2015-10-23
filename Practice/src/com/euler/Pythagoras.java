package com.euler;

public class Pythagoras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<999;i++)
		{
			for(int j=1;j<998-i;j++)
			{
				int k=1000-i-j;
				if(i*i+j*j==k*k)
				{
					System.out.println(i+","+j+","+k+","+(i*j*k));
				}
			}
		}
	}

}
