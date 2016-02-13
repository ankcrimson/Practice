package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MansaAndStones {

  public static void main(String[] args) {
    try(InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(isr);) {
      int t = Integer.parseInt(br.readLine());
      for(int i = 0; i<t; i++) {
        Set<String> hashSet = new HashSet<>(); 
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        
        if(a<b) {
          int tmp=a;
          a=b;
          b=tmp;
        }
        
        for( int j=0; j<n; j++) {
          long x=0;
          long y=0;
            for (int k=0;k<j;k++) {
            x+=a;
          }
          for(int l=j+1;l<n;l++) {
            y+=b;
          }
          String ans=(x+y)+"";
          if(!hashSet.contains(ans)) {
            hashSet.add(ans);
            System.out.print(ans+" ");
          }
        }
        System.out.println();
      }
    }catch(Exception ex){ex.printStackTrace();}

  }

}
