package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LisasWB {

  public static int[] strToIntArr(String[] arr) {
    int[] intArr = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      intArr[i] = Integer.parseInt(arr[i]);
    }
    return intArr;
  }

  public static void main(String[] args) {
    try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);) {
      int ans = 0;
      String[] nk = br.readLine().split(" ");
      int n = Integer.parseInt(nk[0]);
      int k = Integer.parseInt(nk[1]);
      String[] problems = br.readLine().split(" ");
      int[] noOfProblems = strToIntArr(problems);

      int pageNum = 0;
      // int chapter = 0;
      for (int noOfP : noOfProblems) {
        for (int j = 0; j < noOfP; j += k) {
          int min = Math.min(j + k, noOfP);
          if (pageNum >= j && pageNum < min) {
            ans++;
            // System.out.println(pageNum);
          }
          pageNum++;
        }
      }

      System.out.println(ans);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
