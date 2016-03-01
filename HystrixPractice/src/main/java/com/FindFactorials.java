package com;

import java.math.BigInteger;
import java.util.concurrent.Future;

import com.commands.FactorialCommand;

public class FindFactorials {

  public static void main(String[] args) throws Exception {
    BigInteger ten = new BigInteger("5");
    FactorialCommand factorialCommand = new FactorialCommand(ten);
    Future<BigInteger> result = factorialCommand.queue();
    while (!result.isDone())
      System.out.println("Calculating...");
    System.out.println(result.get());
  }

}
