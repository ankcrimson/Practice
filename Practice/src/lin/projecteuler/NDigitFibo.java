package lin.projecteuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class NDigitFibo {

  public static void main(String[] args) {
    BigInteger curr = new BigInteger("1");
    BigInteger prev = new BigInteger("1");
    int[] answers = new int[5001];
    answers[0] = 0;
    answers[1] = 1;

    int i = 1;
    int ctr = 2;
    while (curr.toString().length() < 5000) {
      ctr++;
      BigInteger tmp = curr;
      curr = curr.add(prev);
      prev = tmp;
      int len = curr.toString().length();
      if (len >= i && answers[len] == 0) {
        answers[len] = ctr;
      }
    }
    for (int j = 1; j < answers.length; j++)
      System.out.println(answers[j]);
    try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);) {
      int times = Integer.parseInt(br.readLine());
      for (int t = 0; t < times; t++)
        System.out.println(answers[Integer.parseInt(br.readLine())]);
    } catch (Exception ex) {
    }
  }
}
