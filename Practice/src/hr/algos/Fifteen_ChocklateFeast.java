package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fifteen_ChocklateFeast {

  public int total(int cnt, int cry, int m) {
    if(cnt==0 && cry<m) {
      return 0;
    }
    int val=(cnt+cry)/m;
    int carry=(cnt+cry)%m;
    return val+total(val, carry, m);
  }
  
  public int sum(int n, int c, int m) {
    int num = n/c;
    int carry = 0 ;
    return num+total(num,carry,m);
  }
  
  
  public static void main(String[] args) {
    Fifteen_ChocklateFeast chocklateFeast = new Fifteen_ChocklateFeast();
    try(
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        ) {
      int N = Integer.parseInt(br.readLine());
      for( int i=0;i<N;i++) {
        String[] ncm = br.readLine().split(" ");
        int n = Integer.parseInt(ncm[0]);
        int c = Integer.parseInt(ncm[1]);
        int m = Integer.parseInt(ncm[2]);
        System.out.println(chocklateFeast.sum(n, c, m));
      }
    }catch(Exception ex) {}
    
  }

}
