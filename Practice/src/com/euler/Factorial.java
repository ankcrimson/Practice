package com.euler;

public class Factorial {

	public static String multiply(String a, String b)
	{
		String ans="";
		byte[] arra=a.getBytes();
		byte[] arrb=b.getBytes();
		byte zero='0';
		int cry=0;
		for(int i=0;i<arra.length+arrb.length-1;i++)
		{
			 int val=cry;
			 for(int j=0;j<=i;j++)
			 {
				 int x=0;
				 if(arra.length-j-1>=0)
				 x=arra[arra.length-j-1]-zero;
				 int y=0;
				 if(arrb.length-i+j-1>=0)
				 y=arrb[arrb.length-i+j-1]-zero;
				 val+=x*y;
				 //System.out.println(x+","+y);
			 }
			 //System.out.println();
			 ans=(val%10)+ans;
			 cry=val/10;
		}
		if(cry>0)
			ans=cry+ans;
		
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long ans=1;
		for(int i=1;i<=20;i++)	
		ans*=i;
		String a2=ans+"";
		for(int i=21;i<=100;i++)
		{
			a2=multiply(a2, i+"");
		}
		System.out.println(a2);
		byte[] vals=a2.getBytes();
		long myans=0;
		for(byte b:vals)
		{
			myans+=b-'0';
		}
		System.out.println(myans);
	}

}
