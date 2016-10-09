package com.worldcodesprint5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q3 {

	public static void main(String[] args) {

		long ans = 0;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

			String str = reader.readLine();
			char[] chars = str.toCharArray();
			int left=0;
			int right=chars.length-1;
			boolean incrementLeft=true;
			boolean incrementFlag=false;
			while(right-left>=3){
				if(chars[left]!=chars[right]||incrementFlag){
					incrementFlag=false;
					//increment
					if(chars[left+1]==chars[right]){
						left++;
					} else if(chars[right-1]==chars[left]){
						right--;
					}//if nothing matches
					else if(incrementLeft){
						incrementLeft=false;
						left++;
					}else{
						incrementLeft=true;
						right--;
					}
					continue;
				}
				//if left and right are same, find internal count and find nc2
				int[] counts = new int[26];
				//internal char count
				for(int i=left+1;i<right;i++){
					counts[chars[i]-'a']++;
				}
				for(int alphabetCount:counts){
					long tmp=0;
					if(alphabetCount>1){
						//find nc2 here for chars more than 2
						if (alphabetCount % 2 == 0) {
							tmp = (alphabetCount / 2) * (alphabetCount - 1);

						} else {
							tmp = (alphabetCount) * (alphabetCount -1 / 2);

						}
						ans+=tmp;
						if (ans >= 1000000007){
								ans -= 1000000007;
							}
					}
					
				}
				incrementFlag=true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(ans);
	}

}
