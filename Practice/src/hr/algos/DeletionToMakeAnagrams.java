package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeletionToMakeAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String s1 = br.readLine();
			String s2 = br.readLine();
			int[] chars1 = new int[26];
			int[] chars2 = new int[26];
			for(byte ch:s1.getBytes()){
				chars1[ch-'a']++;
			}
			for(byte ch:s2.getBytes()){
				chars2[ch-'a']++;
			}
			int ans=0;
			for(int i = 0;i<26;i++){
				ans+=(chars1[i]>chars2[i])?chars1[i]-chars2[i]:chars2[i]-chars1[i];
			}
			System.out.println(ans);
		}catch(Exception ex){ex.printStackTrace();}
	}

}
