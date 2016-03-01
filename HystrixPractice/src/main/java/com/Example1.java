package com;

import java.util.concurrent.Future;

import com.commands.ExampleCommand;

import rx.Observable;

public class Example1 {

  public static void main(String[] args) throws Exception {
    ExampleCommand exampleCommand = new ExampleCommand("MyCommand1", true);
    String responseString = exampleCommand.execute();
    Future<String> responseFuture = new ExampleCommand("MyCommand2", false).queue();
    Observable<String> responseObservable = new ExampleCommand("MyCommand3", true).observe();
    System.out.println(responseString);
    while (!responseFuture.isDone()) {
      System.out.println("Waiting for command 2");
    }
    System.out.println(responseFuture.get());
    responseObservable.forEach(System.out::println);
  }

}
