package win.euler;

import java.io.*;
import java.util.*;


public class P079 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Date startTime=new Date();
		String fname="p079_keylog.txt";
		FileReader fr=new FileReader(fname);
		BufferedReader br=new BufferedReader(fr);
		SortedSet<String> slines=new TreeSet<String>();
		String line="";
		
		while((line=br.readLine())!=null)
		{
			slines.add(line);
		}
		
		String start=slines.first().split("")[0];
		
		String ans="";
		
		for(String l:slines)
		{
			//System.out.println(l);
			for(String l2:slines)
			{
				if(l2.contains(start)&&l2.indexOf(start)>0)
					start=l2.split("")[0];
			}
		}
		ans+=start;
		//System.out.println(ans);
		for(int i=0;i<10;i++)
		{
		start=(getNext(slines, start));
		if(start==null)break;
		ans+=start;
		//System.out.println(ans);
		}
		Date endTime=new Date();
		System.out.println(ans+" in "+(endTime.getTime()-startTime.getTime())+" ms.");
	}
	
	public static String getNext(SortedSet<String> slines,String num)
	{
		String nxt="";
		SortedSet<String> candidates=new TreeSet<String>();
		for(String s:slines)
		{
			if(s.contains(num)&&s.indexOf(num)<s.length()-1)
			{
				candidates.add(s.split("")[s.indexOf(num)+1]);
			}
		}
		//System.out.println(candidates);
		if(candidates.size()==0)
			return null;
		nxt=candidates.first();
		for(String s:slines)
		{
			for(String c:candidates)
			{
				if(s.contains(c)&&s.contains(nxt)&&s.indexOf(c)<s.indexOf(nxt))
					nxt=c;
			}
		}
		
		
		return nxt;
	}
}
