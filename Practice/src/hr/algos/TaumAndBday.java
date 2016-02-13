package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaumAndBday {

  public static void main(String[] args) {
    try(
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        ) {
      int t =  Integer.parseInt(br.readLine());
      for(int i = 0; i < t; i++) {
        String[] bw = br.readLine().split(" ");
        long b = Long.parseLong(bw[0]);
        long w = Long.parseLong(bw[1]);
        String[] prices = br.readLine().split(" ");
        long tb = Long.parseLong(prices[0]);
        long tw = Long.parseLong(prices[1]);
        long tc = Long.parseLong(prices[2]);
        long pb = Math.min(tb, tw+tc);
        long pw = Math.min(tw, tb+tc);
        long total = b*pb+w*pw;
        System.out.println(total); 
      }
    }catch(Exception ex){ex.printStackTrace();}
  }

}
