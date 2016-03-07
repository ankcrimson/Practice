package lin;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Code16 { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        String name=br.readLine();
        byte[] arr=name.getBytes();
        int cnts[] =new int[1000];
        byte[] bts=new byte[1000];
        int ctr=-1;
        int c=0;
        byte prev=0;
        for(byte b:arr)
        {
        	if(b==prev)
        		cnts[ctr]++;
        	else
        	{
        		ctr++;
        		bts[ctr]=b;
        		cnts[ctr]++;
        		
        	}
        	prev=b;
        }
        if(ctr==2&&(cnts[0]==cnts[1]&&cnts[1]==cnts[2])&&(bts[0]!=bts[1]&&bts[1]!=bts[2]&&bts[2]!=bts[0]))
        System.out.println("OK");
        else
        	System.out.println("Not OK");
        }
	
	} 
    }