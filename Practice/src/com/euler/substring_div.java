package com.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class substring_div {
static long sum=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,ArrayList<String>> vals=new HashMap<Integer,ArrayList<String>>();
		List<Integer> pms=new ArrayList<Integer>();
		pms.add(17);pms.add(13);pms.add(11);pms.add(7);pms.add(5);pms.add(3);pms.add(2);
		for(int p:pms)
		{
			int tmp=p;
			for(int i=1;p*i<1000;i++)
			{
				tmp=p*i;
				if(vals.containsKey(p))
				{
					ArrayList<String> lst=vals.get(p);
					String val=tmp+"";
					while(val.length()<3)
						val="0"+val;
					lst.add(val);
					vals.put(p, lst);
				}
				else
				{
					ArrayList<String> lst=new ArrayList<String>();
					String val=tmp+"";
					while(val.length()<3)
						val="0"+val;
					lst.add(val);
					vals.put(p, lst);
				}
			}
		}
		
		for(String num:vals.get(pms.get(0)))
		{
		getRes(vals, 1, num,pms);
		//if(ans!=null)System.out.println(addMissing(ans));
		}
		System.out.println(sum);
	}
	
	static public String addMissing(String s)
	{
		for(int i=0;i<10;i++)
		{
			if(s.indexOf(i+"")<0)
				return i+s;
		}
		return null;
	}
	
	public static boolean check(String s)
	{
		for(int i=0;i<10;i++)
		{
			if(s.indexOf(i+"")!=s.lastIndexOf(i+""))
				return false;
		}
		return true;
	}
	
	public static String getRes(Map<Integer,ArrayList<String>> vals,int pp,String curr,List<Integer> pms)
	{
		if(pp==7)
			return curr;
		ArrayList<String> cvals=vals.get(pms.get(pp));
		for(String cv:cvals)
		{
			String tmp1=curr;
			if(cv.substring(1).equals(curr.substring(0, 2)))
			{
				tmp1=cv.substring(0,1)+tmp1;
				if(check(tmp1))
				{
					String ans= getRes(vals, pp+1, tmp1, pms);
					if(ans!=null)
					{
						long res=Long.parseLong(addMissing(ans));
						sum+=res;
						System.out.println(res);
					}
				}
			}
			
		}
		return null;
		
	}
}
