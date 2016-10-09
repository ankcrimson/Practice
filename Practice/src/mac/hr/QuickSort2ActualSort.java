package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.junit.Test;

public class QuickSort2ActualSort {

	public void swap(int[] numbers, int i, int j){
		int tmp=numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=tmp;
	}
	
	public void sort(){
		
	}
	
	public void createPartition(int[] numbers,int l, int r){
		int left=l+1;
		int right=r;
		if(left>right)
			return;
//		print(numbers,l,r);
		
		int pivot=numbers[l];
		
		while(left<=right){
			while(left<=r&&numbers[left]<=pivot){
				left++;
			}
			while(right>l&&numbers[right]>=pivot){
				right--;
			}
			if(left<right){
				swap(numbers,left,right);
			}
		}
		swap(numbers,l,right);
		createPartition(numbers,l,right-1);
		createPartition(numbers,right+1,r);
	}
	
	public static void main(String[] args) {
		QuickSort2ActualSort quickSort2ActualSort=new QuickSort2ActualSort();
		// TODO Auto-generated method stub
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")))){
			br.readLine();//n
			String[] numbersStr=br.readLine().split(" ");
			int[] numbers=new int[numbersStr.length];
			for(int i=0;i<numbersStr.length;i++){
				numbers[i]=Integer.parseInt(numbersStr[i]);
			}
			quickSort2ActualSort.createPartition(numbers, 0, numbers.length-1);
			for(int n:numbers){
				System.out.print(n+" ");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println();
		
	}
	public void print(int[] arr,int l, int r){
		for(int i=l;i<=r;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	@Test
	public void test(){
		for(int i=0;i<1000;i++){
			int randomSize=(int) Math.ceil(Math.random()*100000);
			int[] arr=new int[randomSize];
			//populate
			for(int j=0;j<randomSize;j++){
				arr[j]=(int) Math.ceil(Math.random()*10000);
			}
			createPartition(arr, 0, randomSize-1);
			boolean test=true;
			for(int j=1;j<randomSize&&test;j++){
				test=arr[j-1]<=arr[j];
			}
			if(!test){
				System.out.print("Fail For: ");
				print(arr,0,randomSize-1);
			}
		}
	}

}
