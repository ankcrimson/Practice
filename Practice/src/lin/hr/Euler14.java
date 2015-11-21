package lin.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Euler14 {
	static final int lim=5000001;
	 public static void main(String[] args) throws Exception {
		 int[] cache=new int[lim];
		 int[] ans=new int[lim];
		 int max=0;
		 int maxpos=0;
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int t=Integer.parseInt(br.readLine());
		List<Integer> nums=new LinkedList<Integer>();
		 for(int i=1;i<lim;i++)
		 {
			 nums.clear();
			 int len=1;
			 int num=i;
			 while(num>1)
			 {
				
				 if(num<cache.length&&cache[num]>0)
				 {
					 nums.add(num);
					 len+=cache[num];
					 break;
				 }
				 if(num%2==0)
					 num=num/2;
				 else
					 num=3*num+1;
				 
				 nums.add(num);
				 len++;
			 }
			 int val=2;
			 if(nums.size()>1&&cache[nums.size()-1]>1)
			 val=cache[nums.size()-1];
			 for(int j=nums.size()-1;j>=0;j--)
			 {
				 if(nums.get(j)<cache.length&&nums.get(j)>0)
				 cache[nums.get(j)]=val;
				 val++;
			 }
//			 if(i==3)
//				 {
//				 System.out.println(nums);
//				 System.out.println(cache[10]);
//				 }
			 cache[i]=len;
			 if(len>=max)
			 {
				 max=len;
				 maxpos=i;
			 }
			 ans[i]=maxpos;
			 
		 }
		 for(int j=0;j<t;j++)
		 {
			 int curr=Integer.parseInt(br.readLine());
			 System.out.println(ans[curr]);
		 }
	}
}
