package lin.projecteuler;

public class TriPentHex {

	public static boolean isHex(long num)
	{
		long n1=8*num+1;
		double sqrt=Math.sqrt(n1);
		sqrt++;
		//System.out.println("i="+num+", sqrt="+sqrt);
		return sqrt%4==0;
	
	}
	public static boolean isPent(long num)
	{
		long n1=24*num+1;
		double sqrt=Math.sqrt(n1);
		sqrt++;
		//System.out.println("i="+num+", sqrt="+sqrt);
		return sqrt%6==0;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(long i=1;i<Long.MAX_VALUE;i++)
		{
			long tri=i*(i+1)/2;
			if(isPent(tri)&&isHex(tri))
				System.out.println(tri);
		}
	}

}
