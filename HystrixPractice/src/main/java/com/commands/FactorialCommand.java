package com.commands;

import java.math.BigInteger;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class FactorialCommand extends HystrixCommand<BigInteger> {

  BigInteger myNum;

  final static BigInteger two = new BigInteger("2");
  final static BigInteger one = new BigInteger("1");

  public FactorialCommand(BigInteger num) {
    // TODO Auto-generated constructor stub
    super(HystrixCommandGroupKey.Factory.asKey("factorialCommands"));
    this.myNum = num;
  }

  @Override
  protected BigInteger run() throws Exception {
    BigInteger ans = new BigInteger("2");
    while (myNum.compareTo(two) > 0) {
      ans = ans.multiply(myNum);
      myNum = myNum.subtract(one);
    }
    return ans;
  }

  @Override
  protected BigInteger getFallback() {
    // TODO Auto-generated method stub
    BigInteger errorVal = new BigInteger("-1");
    return errorVal;
  }

}
