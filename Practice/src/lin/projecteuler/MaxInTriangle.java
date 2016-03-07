package lin.projecteuler;

import java.io.FileReader;
import java.util.Scanner;

public class MaxInTriangle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[][] arr=new int[100][];
		FileReader fr=new FileReader("maxintriangle.in");
		Scanner s=new Scanner(fr);
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=new int[i+1];
			for(int j=0;j<=i;j++)
			{
				arr[i][j]=s.nextInt();
			}
			try{
			s.nextLine();
			}catch(Exception e){}
		}
		for(int i=arr.length-1;i>=0;i--)
		{
			for(int j=0;j<=i;j++)
			{
				if(j<i&&i>0)
					if(arr[i][j]>arr[i][j+1])
						arr[i-1][j]=arr[i-1][j]+arr[i][j];
					else
						arr[i-1][j]=arr[i-1][j]+arr[i][j+1];
			}
		}
		System.out.println(arr[0][0]);
	}

}
