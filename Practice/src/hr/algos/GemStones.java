package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GemStones {

  public static void main(String[] args) {
    try (InputStreamReader in = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(in);) {
      int num = Integer.parseInt(br.readLine());
      int[] elements = new int[26];
      String[] strings = new String[num];
      for (int i = 0; i < num; i++) {
        strings[i] = br.readLine();
      }

      String[] abcd = new String[26];
      for (int i = 0; i < 26; i++) {
        abcd[i] = new StringBuffer().append((char) ('a' + i)).toString();
      }

      for (int i = 0; i < 26; i++) {
        for (String s : strings) {
          if (s.contains(abcd[i])) {
            elements[i]++;
          }
        }
      }
      int ans = 0;
      for (int elemnet : elements) {
        if (elemnet == num)
          ans++;
      }
      System.out.println(ans);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
