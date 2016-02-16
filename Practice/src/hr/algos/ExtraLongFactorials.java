package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ExtraLongFactorials {

  public static void main(String[] args) {
    try( InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
            ) {
      int n = Integer.parseInt(br.readLine());
      BigInteger bi = new BigInteger("1");
      for(int i=2;i<=n;i++) {
        bi=bi.multiply(new BigInteger(""+i));
      }
      System.out.println(bi);
    }catch(Exception ex) {ex.printStackTrace();}
  }

}
