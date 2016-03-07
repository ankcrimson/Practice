package com.lambdas;

import java.util.concurrent.TimeUnit;

public class LambdaThreads {

  public static void main(String[] args) {
    Runnable task = () -> {
      System.out.println("This is in runnable within " + Thread.currentThread().getName());
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
    };

    Thread t = new Thread(task);
    t.start();
  }

}
