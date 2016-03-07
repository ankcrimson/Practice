package lin.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Q13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileReader fr=new FileReader("Q13.in");
			BufferedReader br=new BufferedReader(fr);
			
			byte[][] arr=new byte[100][50];
			String line="";
			int i=0;
			while((line=br.readLine())!=null)
			{
				arr[i++]=line.getBytes();
			}
			byte zero='0';
			String res="";
			int cry=0;
			for(i=49;i>=0;i--)
			{
				int val=cry;
				cry=0;
				for(int j=99;j>=0;j--)
				{
					val+=arr[j][i]-zero;
				}
				res=(val%10)+res;
				cry=val/10;
			}
			res=cry+res;
			System.out.println(res.substring(0,10));
		}catch(Exception ex){ex.printStackTrace();}
	}

}
