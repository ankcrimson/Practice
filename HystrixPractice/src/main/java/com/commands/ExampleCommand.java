package com.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class ExampleCommand extends HystrixCommand<String> {

  String command;
  boolean exec;

  public ExampleCommand(String command, boolean exec) {
    super(HystrixCommandGroupKey.Factory.asKey("myGroup"));// why groups
    this.command = command;
    this.exec = exec;
  }

  @Override
  protected String run() throws Exception {
    // TODO Auto-generated method stub
    if (exec)
      throw new RuntimeException();
    return "Success Executing Command " + command + "!!!!!";
  }

  @Override
  protected String getFallback() {
    // TODO Auto-generated method stub
    return "Failed Executing Command " + command + " :P";
  }

}
