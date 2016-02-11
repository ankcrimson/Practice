package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sixteen_CaesarCipher {

  static public String solve(String str, int k) {
    StringBuffer sb = new StringBuffer(str);
    k=k%26;
    for(int i=0;i<str.length();i++) {
      char ch=str.charAt(i);
      if(ch>='A'&&ch<='Z') {
        ch+=k;
        if(ch>'Z') {
          int buffer=ch-1-'Z';
          ch=(char)(buffer+'A');
        }
      } else if(ch>='a'&&ch<='z') {
        ch+=k;
        if(ch>'z') {
          int buffer=ch-1-'z';
          ch=(char)(buffer+'a');
        }
      }
      sb.setCharAt(i, ch);
    }
    return sb.toString();
  }
  
  public static void main(String[] args) {
    try(
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        ) {
        br.readLine();
        String line = br.readLine();
        int k = Integer.parseInt(br.readLine());
        System.out.println(solve(line, k));
    }catch(Exception ex) {ex.printStackTrace();}
  }

}
