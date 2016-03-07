package win.euler;

public class Collatz {

	public static long findNext(long l)
	{
		if(l%2==0)
			return l/2;
		
			return 3*l+1; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long max=0;
		long num=0;
		for(int i=13;i<1000000;i++)
		{
			int cnt=0;
			long l=i;
			while((l=findNext(l))>1)
			{
				//System.out.println(l+" ");
				cnt++;
			}
			cnt+=2;
			//System.out.println(i+"cnt"+cnt);
		if(cnt>max)
			{
			max=cnt;
			System.out.println(i+","+max);
			num=i;
			}
		}
		System.out.println(num);
	}

}
