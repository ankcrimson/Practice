package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ExtraLongFactorials {

  public static String solve(int n) {
      BigInteger bi = new BigInteger("1");
      for(int i=2;i<=n;i++) {
        bi=bi.multiply(new BigInteger(""+i));
      }
      return bi.toString();
  }
  
  public static String solve2(int n) {
    int max=10000000;
    List<Integer> vals = new ArrayList<>();
    vals.add(1);
    for(int i=2;i<=n;i++) {
      int cry=0;
    for(int j=0;j<vals.size();j++) {
      int val=vals.get(j);
      val=val*i;
      val=val+cry;
      cry=0;
      if(val>max) {
        cry=val/max;
        val=val%max;
      }
      vals.set(j, val);
    }
    if(cry>0) {
      vals.add(cry);
    }
    }
    String ans="";
    for(int val:vals)
      ans=val+ans;
    return ans;
  }
  
  public static void main(String[] args) {
    try( InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
            ) {
      int n = Integer.parseInt(br.readLine());
      System.out.println(solve(n));
    }catch(Exception ex) {ex.printStackTrace();}
    
  }

}
