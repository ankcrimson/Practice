package com.euler;

public class TwoThousandSum {

	public static String multiply(String a,String b)
	{
		String res="";
		byte zero='0';
		byte[] arra=a.getBytes();
		byte[] arrb=b.getBytes();
		
		int cry=0;
		
		for(int i=0;i<(arra.length+arrb.length-1);i++)
		{
			int tmp=0;
			for(int j=0;j<=i;j++)
			{
			int x=0;
			if(arrb.length-j-1>=0)
			x=arrb[arrb.length-j-1]-zero;
			int y=0;
			if(arra.length-i+j-1>=0)
			y=arra[arra.length-i+j-1]-zero;
			tmp+=x*y;
			}
			tmp+=cry;
			cry=tmp/10;
			res=(tmp%10)+res;
		}
		if(cry!=0)
		res=cry+res;
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res="1";
		long num=1;
		
		for(int pow=0;pow<25;pow++)
			num*=2;
		res=num+"";
		
		res=multiply(res, res);//50
		
		String fifty=res;
		
		res=multiply(res, res);//100
		res=multiply(res, res);//200
		res=multiply(res, fifty);//250
		res=multiply(res, res);//500
		res=multiply(res, res);//1000
		
		
		int ans=0;
		int zero='0';
		byte[] arr=res.getBytes();
		for(byte b:arr)
		{
			ans+=b-zero;
		}
		System.out.println(ans);
		//String a="1234";
		//String b="56789";
		
		//System.out.println(multiply(a, b));
	}

}
