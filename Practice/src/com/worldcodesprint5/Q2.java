package com.worldcodesprint5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2 {
	// https://www.hackerrank.com/contests/world-codesprint-5/challenges/string-construction
	public static void main(String[] args) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

			int t=Integer.parseInt(reader.readLine());
			while(t-->0){
			String str = reader.readLine();
			char[] chars = str.toCharArray();
			// track if a character is present
			int[] charPresent = new int[26];
			for (char ch : chars) {
				charPresent[ch - 'a'] = 1;
			}
			int counter = 0;
			for (int i : charPresent) {
				counter += i;
			}
			System.out.println(counter);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
