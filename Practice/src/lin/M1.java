package lin;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class M1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		InputStream is=new FileInputStream("m1");
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++)
		{
			String str=br.readLine();
			
			int qlen=str.length();
			
			int n=Integer.parseInt(br.readLine());
			
			
			for(int j=0;j<n;j++)
			{
				String qry=br.readLine();
				String[] arr=qry.split("");
				
				
				int min=str.length();
				int max=0;
				int start=0;
				long sum=0;
			//	System.out.println("-----------------");
				while(max>=0&&min>=0)
				{
					min=str.length();
					max=0;
				for(String s:arr)
				{
				//	System.out.println(">>>>>>>."+s+"<<<"+start+"<<<<<"+str);
					int tmp=str.indexOf(s,start);
					if(tmp>max)max=tmp;
					if(tmp<min)min=tmp;
				}
				int tmp=qlen-max;
				start=min+1;
	System.out.println(min+"+"+tmp);
				if(min>=0&&max>=0)
					sum+=min+tmp;
				}
			sum-=1;
			System.out.println("SUM:"+sum);
	//		System.out.println("-----------------");
				
			}
		}
	}

}
