package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RansomeNote {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			br.readLine();//not needed
			String[] magizineWords = br.readLine().split(" ");
			String[] letterWords = br.readLine().split(" ");
			Map<String,Integer> magazineCount = new HashMap<>();
			for(String magazineWord: magizineWords){
				
				if(magazineCount.containsKey(magazineWord)){
					int curr = magazineCount.get(magazineWord);
					magazineCount.put(magazineWord, curr+1);
				}else{
					magazineCount.put(magazineWord, 1);
				}
			}
			boolean success=true;
			for(String letterWord:letterWords){
				if(magazineCount.containsKey(letterWord)&& magazineCount.get(letterWord)>0){
					int updatedCount = magazineCount.get(letterWord)-1;
					magazineCount.put(letterWord, updatedCount);
				}else{
					success=false;
					break;
				}
			}
			System.out.println((success)?"Yes":"No");
		}catch(Exception ex){ex.printStackTrace();}
	}

}
