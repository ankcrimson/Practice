package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlternatingCharacters {

  public static void main(String[] args) {
    try (InputStreamReader in = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(in);) {
      int t = Integer.parseInt(br.readLine());
      for (int i = 0; i < t; i++) {
        char[] chars = br.readLine().toCharArray();
        boolean state = false;
        if (chars[0] == 'A') {
          state = true;
        }
        int ans = 0;
        for (int j = 1; j < chars.length; j++) {
          if (state && chars[j] == 'B' || !state && chars[j] == 'A') {
            state = !state;
          } else
            ans++;
        }
        System.out.println(ans);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

}
