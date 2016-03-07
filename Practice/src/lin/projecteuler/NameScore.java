package lin.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;

public class NameScore {

	public static void quickSort(String arr[],int start,int end,int pivot) throws Exception
	{
		
	}
	public static void bubbleSort(String arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(j+1<arr.length)
				if(arr[j].compareTo(arr[j+1])>0)
				{
					String tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("p022_names.txt");
		BufferedReader br=new BufferedReader(fr);
		String allNames="";
		allNames=br.readLine();
		allNames=allNames.replaceAll("\"", "");
		String[] nameArr=allNames.split(",");
		bubbleSort(nameArr);
		long ans=0;
		for(int i=0;i<nameArr.length;i++)
			{
			int sum=0;
			byte[] vals=nameArr[i].getBytes();
			byte zero='A';
			for(byte b:vals)
			{
				sum+=b-zero+1;
			}
			//System.out.println(nameArr[i]+","+sum);
			ans+=sum*(i+1);
			}
		System.out.println(ans);
	}

}
