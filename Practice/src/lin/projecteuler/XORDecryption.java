package lin.projecteuler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.StringTokenizer;

public class XORDecryption {

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
		
		outermost: for(byte i='a';i<='z';i++)
		{
			for(byte j='a';j<='z';j++)
			{
				next: for(byte k='a';k<='z';k++)
				{
					String ans="";
					for(int l=0;l<bytes.length;l+=3)
					{
						try{
						char a=(char) (bytes[l]^i);
						ans+=a;
						char b=(char) (bytes[l+1]^j);
						ans+=b;
						char c=(char) (bytes[l+2]^k);
							ans+=c;
						}catch(Exception e){}
					}
					if(ans.contains(" and "))
					{
					
						finalText=ans;
						//System.out.println(ans);
					break outermost;
					}
				}
			}	
		}
		//System.out.println(finalText);
		byte[] fbytes=finalText.getBytes();
		int fans=0;
		for(byte b:fbytes)
			fans+=b;
		
		System.out.println(fans);
		Date now=new Date();
		System.out.println("Time Taken:"+(now.getTime()-start.getTime())+" ms");
	}

}
