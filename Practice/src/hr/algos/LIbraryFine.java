package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LIbraryFine {

  public static void main(String[] args) {
    try(InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);) {
      String[] actual = br.readLine().split(" ");
      String[] expected = br.readLine().split(" ");
      int yearDiff = Integer.parseInt(actual[2])-Integer.parseInt(expected[2]);
      if(yearDiff>0) {
        System.out.println("10000");
        return;
      }
      int monthDiff = Integer.parseInt(actual[1])-Integer.parseInt(expected[1]);
      if(monthDiff>0 && yearDiff == 0) {
        System.out.println(500*monthDiff);
        return;
      }
      int dateDiff =  Integer.parseInt(actual[0])-Integer.parseInt(expected[0]);
      if(dateDiff>0 && yearDiff ==0 && monthDiff == 0) {
        System.out.println(dateDiff*15);
        return;
      }
      System.out.println(0);
    }catch( Exception ex) {
      ex.printStackTrace();
    }
    
  }
}
