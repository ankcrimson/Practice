package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pangrams {

  public static void main(String[] args) {

    try (InputStreamReader in = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(in);) {
      String str = br.readLine().toLowerCase();
      int[] arr = new int[26];
      for (char ch : str.toCharArray()) {
        if (ch >= 'a' && ch <= 'z') {
          arr[ch - 'a']++;
        }
      }
      for (int i = 0; i < 26; i++) {
        if (arr[i] == 0) {
          System.out.println("not pangram");
          return;
        }
      }
      System.out.println("pangram");
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

}
