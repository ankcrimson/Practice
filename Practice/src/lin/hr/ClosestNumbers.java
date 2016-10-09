package lin.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

public class ClosestNumbers {

	public void swap(int i, int j, int[] arr){
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	public void print(int l, int r, int[] arr){
		for(int i=l;i<=r;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	//quicksort
	public void partition(int l,int r, int[] arr){
		int left=l+1;
		int right=r;
		if(left>right)
			return;
		int pivot=arr[l];
		while(left<=right){
			while(left<right&&arr[left]<pivot){
				left++;
			}
			while(right>=left&&arr[right]>=pivot){
				right--;
			}
			if(left<right){
				swap(left,right,arr);
			}
		}
		swap(l,right,arr);
		partition(l,right-1,arr);
		partition(right+1,r,arr);
	}
	
	public void solve(int[] array){
		partition(0, array.length-1, array);
		String ans="";
		int min=Integer.MAX_VALUE;
		for(int i=1;i<array.length;i++){
			int diff=array[i]-array[i-1];
			if(diff<min){
				ans=array[i-1]+" "+array[i];
				min=diff;
			} else if(diff==min){
				ans=" "+array[i-1]+" "+array[i];
			}
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		ClosestNumbers closestNumbers=new ClosestNumbers();
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in, "UTF-8"))){
			br.readLine();//len
			String[] arrS=br.readLine().split(" ");
			int[] arr=new int[arrS.length];
			for(int i=0;i<arrS.length;i++){
				arr[i]=Integer.parseInt(arrS[i]);
			}
			closestNumbers.solve(arr);
		}catch(Exception ex){ex.printStackTrace();}
	}
	
	@Test
	public void test(){
		int[] arr={5,4,3,2};
		solve(arr);
	}

}
