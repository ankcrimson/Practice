package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

import junit.framework.Assert;

public class KaprekarNumber {

  public static boolean isKaprekarNumber(long num) {
    long square = num * num;

    int len = (square + "").length();
    int firstHalf = len / 2;
    int secondHalf = len - firstHalf;
    long second = square % (long) (Math.pow(10, secondHalf));
    long first = square / (long) (Math.pow(10, secondHalf));
    // System.out.println(first + ", " + second);
    if (len > 1 && second == 0)
      return false;
    return (first + second == num);
  }

  public static String solve(int a, int b) {
    StringBuffer result = new StringBuffer();
    for (int i = a; i <= b; i++) {
      if (isKaprekarNumber(i))
        result.append(i + " ");
    }
    if (result.length() == 0)
      result.append("INVALID RANGE");
    return result.toString().trim();
  }

  public static void main(String[] args) {
    try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);) {
      int a = Integer.parseInt(br.readLine());
      int b = Integer.parseInt(br.readLine());
      System.out.println(solve(a, b));
    } catch (Exception ex) {
    }
  }

  @Test
  public void test() {
    Assert.assertTrue(isKaprekarNumber(1));
    Assert.assertTrue(isKaprekarNumber(9));
    Assert.assertTrue(isKaprekarNumber(55));
    Assert.assertTrue(isKaprekarNumber(99));
    Assert.assertTrue(isKaprekarNumber(45));
    Assert.assertTrue(isKaprekarNumber(297));
    Assert.assertTrue(isKaprekarNumber(77778));
    Assert.assertEquals("1 9 45 55 99", solve(1, 100));
    Assert.assertEquals("1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999", solve(1, 99999));
  }

}
