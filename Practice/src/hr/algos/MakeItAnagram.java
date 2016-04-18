package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakeItAnagram {



  public static void main(String[] args) {

    try (InputStreamReader in = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(in);) {
      String a = br.readLine();
      String b = br.readLine();
      int[] arrA = new int[26];
      int[] arrB = new int[26];
      for (char ch : a.toCharArray()) {
        arrA[ch - 'a']++;
      }
      for (char ch : b.toCharArray()) {
        arrB[ch - 'a']++;
      }
      int ans = 0;
      for (int i = 0; i < 26; i++) {
        if (arrA[i] != arrB[i]) {
          ans += Math.abs(arrA[i] - arrB[i]);
        }
      }
      System.out.println(ans);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

}
