package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * https://www.hackerrank.com/challenges/cavity-map
 * @author ankcrimson
 *
 */
public class CavityMap {

  public static void main(String[] args) {
    try(
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        ) {
      int n=Integer.parseInt(br.readLine());
      char[][] arr = new char[n][];
      for(int i=0;i<n;i++)
        arr[i]=br.readLine().toCharArray();
      
      for(int i=1;i<n-1;i++) {
        for(int j=1;j<n-1;j++) {
          if(arr[i][j]>arr[i-1][j]&&arr[i][j]>arr[i+1][j]&&arr[i][j]>arr[i][j-1]&&arr[i][j]>arr[i][j+1])
            arr[i][j]='X';
        }
      }
      
      for(int i=0;i<n;i++)
        System.out.println(new String(arr[i]));
      
    }catch(Exception ex) {
      ex.printStackTrace();
    }

  }

}
