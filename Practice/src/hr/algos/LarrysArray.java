package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LarrysArray {



  public static void main(String[] args) {
    try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);) {
      int t = Integer.parseInt(br.readLine());
      for (int i = 0; i < t; i++) {
        int size = Integer.parseInt(br.readLine());
        int[] numbers = new int[size];


        String[] numbersInString = br.readLine().split(" ");
        for (int j = 0; j < size; j++) {
          numbers[j] = Integer.parseInt(numbersInString[j]);
        }
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);

        for (int k = 0; k < sorted.length; k++) {
          int curr = sorted[k];
          int ind = 0;
          for (; ind < numbers.length; ind++) {
            if (numbers[ind] == curr)
              break;
          }
          while (ind > k + 2) {
            int tmp = numbers[ind];
            numbers[ind] = numbers[ind - 1];
            numbers[ind - 1] = numbers[ind - 2];
            numbers[ind - 2] = tmp;
            ind = ind - 2;
          }
          if (numbers[k] == curr) {
          } // do nothing
          else if ((k + 2) < numbers.length && numbers[k + 1] == curr) {
            numbers[k + 1] = numbers[k + 2];
            numbers[k + 2] = numbers[k];
            numbers[k] = curr;
          } else if ((k + 2) < numbers.length && numbers[k + 2] == curr) {
            numbers[k + 2] = numbers[k + 1];
            numbers[k + 1] = numbers[k];
            numbers[k] = curr;
          } else {
            // System.out.println("Something went wrong");
          }
        }

        int len = numbers.length;

        System.out.println(numbers[len - 1] > numbers[len - 2] && numbers[len - 2] > numbers[len - 3] ? "YES" : "NO");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
