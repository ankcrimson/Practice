package com.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;


class Factorial implements Runnable {

  long x;

  public Factorial(long x) {
    this.x = x;
  }

  @Override
  public void run() {
    System.out.println("Factorial of " + x + " is " + factorial(x));
  }

  public BigInteger factorial(long num) {
    BigInteger ans = new BigInteger(num + "");
    while (num-- > 2) {
      ans = ans.multiply(new BigInteger("" + num));
    }
    return ans;
  }

}


public class FuturesTest {

  ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    FuturesTest futuresTest = new FuturesTest();

    try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr);) {
      String num = null;
      while ((num = br.readLine()) != null) {
        if (num.length() == 0)
          break;
        long n = Long.parseLong(num);
        Factorial fact = new Factorial(n);
        futuresTest.scheduledThreadPoolExecutor.submit(fact);
      }
    } catch (IOException ioexec) {
      System.out.println("IOException :( :" + ioexec);
    }
    System.out.println("Quitting, Bye..");

    futuresTest.scheduledThreadPoolExecutor.shutdown();
  }

}
