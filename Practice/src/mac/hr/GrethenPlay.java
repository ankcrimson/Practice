package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GrethenPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				InputStreamReader isr=new InputStreamReader(System.in);
				BufferedReader br=new BufferedReader(isr);
		){
			final String[] mnq=br.readLine().split(" ");
			final int m=Integer.parseInt(mnq[0]);
			final int n=Integer.parseInt(mnq[1]);
			final int q=Integer.parseInt(mnq[2]);
			
			Map<Integer,Integer> scenes=new HashMap<Integer, Integer>();//number of actors
			final int[] actors=new int[n];//scene assigned
			final String[] acts=br.readLine().split(" ");
			
			for(int i=0;i<acts.length;i++)
			{
				Integer as=Integer.parseInt(acts[i]);
				actors[i]=as;
				if(scenes.containsKey(as))
					scenes.put(as, scenes.get(as).intValue()+1);
				else
					scenes.put(as, 1);
				
			}
			//System.out.println(scenes);
			for(int i=0;i<q;i++)
			{
				String[] qn=br.readLine().split(" ");
				if(qn[0].equals("1"))
				{
					final int ni=Integer.parseInt(qn[1]);
					final int mi=Integer.parseInt(qn[2]);
					scenes.put(actors[ni], scenes.get(actors[ni]).intValue()-1);
					actors[ni]=mi;
					if(scenes.containsKey(mi))
						scenes.put(mi, scenes.get(mi).intValue()+1);
					else
						scenes.put(mi, 1);
					
				}
				else
				{
					final int p=Integer.parseInt(qn[1]);
					int ans=m;
					for(int tmp:scenes.values())
						if(tmp>=p)
							ans--;
					System.out.println(ans);
				}
				//System.out.println(scenes);
			}
		}catch(Exception ex){ex.printStackTrace();}
		
	}
	

}
