package lin.projecteuler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.StringTokenizer;

public class XORDecryption_wo_ButeForce {

	public static void conv(byte[] bytes, int pos)
	{
		byte a='a';
		int max=0;
		for(byte i='a';i<='z';i++)
		{
			int curr=0;
			for(int j=pos;j<bytes.length;j+=3)
			{
				byte b=bytes[j];
				if(((b^i)>='a'&&(b^i)<='z')||(b^i)==' ')
				{
					curr++;
				}
			}
			if(curr>max)
			{
				a=i;
				max=curr;
			}
		}
		for(int j=pos;j<bytes.length;j+=3)
		{
			bytes[j]=(byte)(bytes[j]^a);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Date start=new Date();
		String finalText="";
		
		//FileInputStream fis=new FileInputStream("Copy of p059_cipher.txt");
		FileInputStream fis=new FileInputStream("p059_cipher.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		String line=br.readLine();
		StringTokenizer st=new StringTokenizer(line, ",");
		byte[] bytes=new byte[st.countTokens()];
		int cnt=0;
		while(st.hasMoreTokens())
		{
			bytes[cnt++]=Byte.parseByte(st.nextToken());
		}
		
		conv(bytes,0);
		conv(bytes,1);
		conv(bytes,2);
		
		
		
		//System.out.println(new String(bytes));
		byte[] fbytes=bytes;
		int fans=0;
		for(byte b:fbytes)
			fans+=b;
		
		System.out.println(fans);
		Date now=new Date();
		System.out.println("Time Taken:"+(now.getTime()-start.getTime())+" ms");
	}

}
