package com.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSorter {



  public static void main(String[] args) {
    List<String> strings = new ArrayList<>();
    strings.add("Bhanu");
    strings.add("Ankur");
    strings.add("Ramakant");
    strings.add("Hari");

    System.out.println(strings);

    Collections.sort(strings, (p1, p2) -> p1.compareTo(p2));

    System.out.println(strings);

  }


}
