package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AcmICPC {

  public static int[] stringToIntArr(String val, String regex) {
    int[] arr = new int[val.length()];
    String[] sarr = val.split(regex);
    for (int i = 0; i < sarr.length; i++) {
      arr[i] = Integer.parseInt(sarr[i]);
    }
    return arr;
  }

  public static int concat(int[] a, int[] b) {
    int ones = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] == 1 || b[i] == 1) {
        ones++;
      }
    }
    return ones;
  }

  public static void main(String[] args) {
    try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);) {
      String[] nm = br.readLine().split(" ");
      int n = Integer.parseInt(nm[0]);
      int m = Integer.parseInt(nm[1]);
      int[][] arr = new int[n][m];
      for (int i = 0; i < n; i++) {
        String line = br.readLine();
        arr[i] = stringToIntArr(line, "");
      }
      int max = 0;
      int numMax = 0;
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          int ones = concat(arr[i], arr[j]);
          if (ones > max) {
            numMax = 1;
            max = ones;
          } else if (ones == max) {
            numMax++;
          }
        }
      }
      System.out.println(max);
      System.out.println(numMax);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

}
