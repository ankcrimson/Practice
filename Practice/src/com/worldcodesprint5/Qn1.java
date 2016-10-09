package com.worldcodesprint5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//https://www.hackerrank.com/contests/world-codesprint-5/challenges/camelcase

public class Qn1 {

	public static void main(String[] args) {
		// initial count=1
		int count=1;
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){
			String str=reader.readLine();
			char[] characters=str.toCharArray();
			for(char ch:characters){
				if(ch>='A'&&ch<='Z'){
					count++;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println(count);
	}

}
