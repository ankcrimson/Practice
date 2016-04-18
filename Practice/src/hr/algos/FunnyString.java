package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FunnyString {

  public static void main(String[] args) {
    try (InputStreamReader in = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(in);) {
      int t = Integer.parseInt(br.readLine());
      outer: for (int i = 0; i < t; i++) {
        String a = br.readLine();
        char[] charsA = a.toCharArray();
        int len = charsA.length;
        for (int j = 1; j < len; j++) {
          if (!(Math.abs(charsA[j] - charsA[j - 1]) == Math.abs(charsA[len - j - 1] - charsA[len - j]))) {
            System.out.println("Not Funny");
            continue outer;
          }
        }
        System.out.println("Funny");
      }
    } catch (Exception ex) {
    }

  }

}
