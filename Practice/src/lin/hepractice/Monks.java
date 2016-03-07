package lin.hepractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Monks {

	public static int check(int e,int[] pos,int monks)
	{
		e=e*2;
		
		int reach=pos[0]+e;
		int mindiff=Integer.MAX_VALUE;
		monks--;
		for(int i=1;i<pos.length;i++)
		{
			if(pos[i]<=reach)
				{
				if(mindiff>=reach-pos[i])
					mindiff=reach-pos[i];
				continue;
				}
			reach=pos[i]+e;
			monks--;
		}
		if(monks<0)
			mindiff=-1;
		
		return mindiff;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("monks.in");
		BufferedReader br=new BufferedReader(fr);
		String[] nk=br.readLine().split(" ");
		int n=Integer.parseInt(nk[0]);
		int k=Integer.parseInt(nk[1]);
		String[] poss=br.readLine().split(" ");
		int[] pos=new int[n];
		for(int  i=0;i<n;i++)
		{
			pos[i]=Integer.parseInt(poss[i]);
		}
		Arrays.sort(pos);
		
		int emax=10000000;
		int emin=0;
		int res=0;
		boolean iterate=true;
		while(iterate)
		{
			int e=(emax+emin)/2;
			res=e;
			int chk=check(e,pos,k);
			if(chk==-1)
				emin=e+1;
			else if(chk==0)
				break;
			else emax=e-1;
			System.out.println(e);
		
		}
		System.out.println(res);
	}

}
