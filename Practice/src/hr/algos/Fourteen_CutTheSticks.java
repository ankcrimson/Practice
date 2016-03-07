package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fourteen_CutTheSticks {

  public void swap(int[] arr, int i, int j) {
    int tmp=arr[i];
    arr[i]=arr[j];
    arr[j]=tmp;
  }
  
  public int partition(int[] arr, int l, int r) {
    int pivot=r;
    int i=l-1;
    for(int j=l;j<=r-1;j++) {
      if(arr[j]<arr[pivot]){
        i++;
        swap(arr,i,j);
      }
        
    }
    swap(arr,i+1,r);
    return i+1;
  }
  
  public void quickSort(int[] arr, int l, int r) {
    if(l<r) {
    int pivot=partition(arr, l, r);
    quickSort(arr, l, pivot-1);
    quickSort(arr, pivot+1, r);
    }
  }
  
  public void shuffle(int[] arr) {
    for(int i=1;i<arr.length;i++) {
      int rand = (int)(Math.random()*(i+1));
      swap(arr, i, rand);
    }
  }
  
  public void sort(int[] arr) {
    shuffle(arr);
    quickSort(arr, 0, arr.length-1);
  }
  
  
  public static void main(String[] args) {
    Fourteen_CutTheSticks cutTheSticks = new Fourteen_CutTheSticks();
    try(
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        ) {
       int n=Integer.parseInt(br.readLine());
       String[] arr=br.readLine().split(" ");
       int[] heights=new int[arr.length];
       for(int i=0;i<arr.length;i++)
         heights[i]=Integer.parseInt(arr[i]);
       //sort the sticks
       cutTheSticks.sort(heights);
       int curr=-1;
       for(int i=0;i<heights.length;i++) {
         if(curr!=heights[i])
           System.out.println(arr.length-i);
           curr=heights[i];
       }
       
    }catch(Exception ex){ex.printStackTrace();}
  }

}
