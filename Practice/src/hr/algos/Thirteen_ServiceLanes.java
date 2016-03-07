package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Thirteen_ServiceLanes {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try(
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);) {
      String[] nt = br.readLine().split(" ");
      int N=Integer.parseInt(nt[0]);
      int T=Integer.parseInt(nt[1]);
      String[] vals = br.readLine().split(" ");
      int[] widths=new int[vals.length];
      for(int i=0;i<vals.length;i++) {
        widths[i]=Integer.parseInt(vals[i]);
      }
      for(int i=0;i<T;i++) {
        String[] ab=br.readLine().split(" ");
        int a=Integer.parseInt(ab[0]);
        int b=Integer.parseInt(ab[1]);
        int min=4;
        for(int j=a;j<=b;j++) {
          if(widths[j]<min)
            min=widths[j];
        }
        System.out.println(min);
      }
    }catch(Exception ex) {ex.printStackTrace();}
  }

}
