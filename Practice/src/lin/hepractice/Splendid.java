package lin.hepractice;



public class Splendid {

	public static long calcNext(long lim)
	{

		  int y=1;
	        for(int i=0;i<lim;i++)
	        {
	        	long x=(long)Math.pow(2, ((2*i)+1));
	        	y+=x;
	        }
	        return y;
	}
	  public static void main(String args[] ) throws Exception {
		
		  int N=10;
		  
		  N=(int)Math.pow(2, N);
		  N++;
		  long[] arr=new long[N+1];
		  for(int r=1;r<N;r++)
		  {
			  String row="";
			  int val=1;
			  int y=r-1;
				 int cnt2=0;
				 while(y>0&&y%2==0)
				 {
					 y/=2;
					 cnt2++;
				 }
				 //val+=calcNext(cnt2);
				
				 long tmp=calcNext(cnt2)*2;
				if(r==1)tmp=0;
				//System.out.println(tmp);
				  for(int i=1;i<N;i++)
		{
			 int cnt=0;
			 int x=i;
			 while(x%2==0)
			 {
				 x/=2;
				 cnt++;
			 }
			 if(r==1)
				{
				tmp=0;
				arr[i]=val;
				}
			else
			{
				arr[i]=arr[i]+tmp;
			}
			 row+=(arr[i]+" ");
			val+=(calcNext(cnt));
			
		}
		  System.out.println(row.trim());
		  }
	    }
}
