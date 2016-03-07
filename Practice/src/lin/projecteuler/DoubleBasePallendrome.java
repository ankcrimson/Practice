package lin.projecteuler;

import java.util.Date;

public class DoubleBasePallendrome {

	public static String addBin(String a,String b)
	{
		String res="";
		byte[] arra=a.getBytes();
		byte[] arrb=b.getBytes();
		int cry=0;
		int zero='0';
		
		for(int i=0;i<arra.length||i<arrb.length;i++)
		{
			int x=0;
			if(arra.length-1-i>=0)
				x+=arra[arra.length-1-i]-zero;
			if(arrb.length-1-i>=0)
				x+=arrb[arrb.length-1-i]-zero;
			
			x+=+cry;
			cry=x/2;
			x=x%2;
			res=x+res;
		}
		if(cry>0)
		res=cry+res;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date a=new Date();
		String res="1";
		long ans=0;
		for(int i=1;i<1000000;i+=2,res=addBin(res, "10"))
		{
			StringBuffer sb1=new StringBuffer(i+"");
			StringBuffer sb2=new StringBuffer(res);
			sb1.reverse();
			sb2.reverse();
			if((i+"").equals(sb1.toString())&&res.equals(sb2.toString()))
			{
				ans+=i;
			}
		}
		Date b=new Date();
	System.out.println(ans+" in "+(b.getTime()-a.getTime())+" ms");
	}

}
