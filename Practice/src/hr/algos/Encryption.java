package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Encryption {

  public static void main(String[] args) {
    try(InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(isr);) {
      String line = br.readLine();
      int len = line.length();
      char[] chars=line.toCharArray();
      
      int x = (int)Math.floor(Math.sqrt(len));
      int y = (int)Math.ceil(Math.sqrt(len));
      if(x*y<len)x++;
      char[][] arr = new char[x][y];
        char tmp=arr[0][0];
      int j=0,k=0;
      for(int i=0;i<len;i++) {
        if(k==y) {
          k=0;
          j++;
        }
        arr[j][k++]=chars[i];
      }
      for(j=0;j<y;j++) {
        for(k=0;k<x;k++) {
            if(arr[k][j]!=tmp)
          System.out.print(arr[k][j]);
        }
        System.out.print(" ");
      }
        System.out.println();
    }catch(Exception ex){ex.printStackTrace();}

  }

}
