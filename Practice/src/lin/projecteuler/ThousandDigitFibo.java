package lin.projecteuler;

public class ThousandDigitFibo {

	public static String add(String a,String b)
	{
		String ans="";
		byte[] as=a.getBytes();
		byte[] bs=b.getBytes();
		byte zero='0';
		int cry=0;
		for(int i=0;i<as.length||i<bs.length;i++)
		{
			int x=0;
			int y=0;
			if(as.length-i-1>=0)
				x=as[as.length-i-1]-zero;
			if(bs.length-i-1>=0)
				y=bs[bs.length-i-1]-zero;
			int z=x+y+cry;
			ans=(z%10)+ans;
			cry=z/10;
		}
		if(cry!=0)
			ans=cry+ans;
		
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num="2";
		long ind=3;
		while(num.length()!=1000)
		{
			num=add(num,ind+"");
			ind++;
			System.out.println(ind+", "+num);
			
		}
		System.out.println(num);
		
	}

}
