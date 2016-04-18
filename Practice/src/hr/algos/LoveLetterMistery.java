package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoveLetterMistery {

  public static void main(String[] args) {
    try (InputStreamReader in = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(in);) {
      int t = Integer.parseInt(br.readLine());
      for (int i = 0; i < t; i++) {
        char[] chars = br.readLine().toCharArray();
        int lby2 = chars.length / 2;
        int ans = 0;
        for (int j = 0; j < lby2; j++) {
          ans += Math.abs(chars[j] - chars[chars.length - j - 1]);
        }
        System.out.println(ans);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

}
