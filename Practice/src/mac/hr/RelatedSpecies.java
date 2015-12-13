package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;

public class RelatedSpecies {

	public static boolean solve(int n, String[] a, String[] b) throws Exception
	{
		boolean same=true;
		long c=0;
		for(int i=0;i<n;i++)
		{
			long x=Long.parseLong(a[i]);
			long y=Long.parseLong(b[i]);
			
			long min=(x<y)?(x>=c)?x:y:(y>=c)?y:x;
			
			if(min>=c)
				c=min;
			else
			{
				same=false;
				break;
			}
		}
		
	return same;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				InputStreamReader isr=new InputStreamReader(System.in);
				BufferedReader br=new BufferedReader(isr);
		){
			int t=Integer.parseInt(br.readLine());
            for(int l=0;l<t;l++)
            {
            	int n=Integer.parseInt(br.readLine());
        		String[] a=br.readLine().split(" ");
        		String[] b=br.readLine().split(" ");
        		
			if(solve(n,a,b))
				System.out.println("YES");
			else
				System.out.println("NO");
            }
		}catch(Exception ex){}
	}
	@Test
	public void test()
	{
		try{
			Assert.assertTrue( solve(3, new String[]{"1","2","3"}, new String[]{"4","4","4"}));
			Assert.assertTrue( !solve(3, new String[]{"3","2","1"}, new String[]{"6","5","4"}));
			Assert.assertTrue( solve(2, new String[]{"1","0"}, new String[]{"10","2"}));
			Assert.assertTrue( solve(3, new String[]{"1","1","1"}, new String[]{"4","5","3"}));
			Assert.assertTrue( solve(3, new String[]{"100","1000","100"}, new String[]{"4","5","1000"}));
			
			
		}catch(Exception ex){}
	}

}
