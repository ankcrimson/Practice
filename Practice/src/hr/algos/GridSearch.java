package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;

/*
 * https://www.hackerrank.com/challenges/the-grid-search
 */
public class GridSearch {

  public static boolean searchV(String[] master, int x1, int y1, String[] sub) {
    for(int i=y1,j=0;j<sub.length;i++,j++) {
      if(master[i].indexOf(sub[j],x1)!=x1)
        return false;
    }
    return true;
  }
  
  public static boolean findSubArr(String[] master, int x1, int y1, String[] sub, int y2) {
   
   int ind = -1;
   for(int i=0;i<=master.length-sub.length;i++) {
     while((ind=master[i].indexOf(sub[0],ind+1))!=-1) {
       if(searchV(master, ind, i, sub)) return true;
     }  
   }
   
   return false;
  }
  
  public static void main(String[] args) {
    try(
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        ) {
      int t = Integer.parseInt(br.readLine());
      for(int i=0;i<t;i++) {
        int x1 = Integer.parseInt(br.readLine().split(" ")[0]);
        String[] mainArr = new String[x1];
        for(int j=0;j<mainArr.length;j++) {
          mainArr[j] = br.readLine();
        }
        int x2 = Integer.parseInt(br.readLine().split(" ")[0]);
        String[] subArr = new String[x2];
        for(int j=0;j<subArr.length;j++) {
          subArr[j] = br.readLine();
        }
        String ans = findSubArr(mainArr, 0, 0, subArr, 0)?"YES":"NO";
        System.out.println(ans);
      }
    } catch(Exception ex) {ex.printStackTrace();}
  }
  
  @Test
  public void test() {
    String[] mainArr={"01","11","00"};
    String[] subArr={"1","1"};
    Assert.assertTrue(findSubArr(mainArr, 0, 0, subArr, 0));
  }

}
