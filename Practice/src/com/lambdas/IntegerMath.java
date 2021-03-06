package com.lambdas;

@FunctionalInterface
interface BinaryOperation {
  int operation(int x, int y);
}


public class IntegerMath {

  public static void main(String[] args) {
    BinaryOperation add = (a, b) -> a + b;
    BinaryOperation sub = (a, b) -> a - b;
    BinaryOperation diff = (a, b) -> (a > b) ? a - b : b - a;
    System.out.printf("Addn of %d,%d is %d\n", 3, 4, add.operation(3, 4));
    System.out.printf("Subn of %d,%d is %d\n", 3, 4, sub.operation(3, 4));
    System.out.printf("Diff of %d,%d is %d\n", 3, 4, diff.operation(3, 4));
  }

}
