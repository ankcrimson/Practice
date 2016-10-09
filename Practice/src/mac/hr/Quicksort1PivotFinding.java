package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Quicksort1PivotFinding {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in, "UTF-8"))){
			int numberOfElements=Integer.parseInt(br.readLine());
			String[] elements=br.readLine().split(" ");
			int[] numbers=new int[elements.length];
			for(int i=0;i<elements.length;i++){
				numbers[i]=Integer.parseInt(elements[i]);
			}
			int pivot=numbers[0];
			
			int[] left=new int[numberOfElements];
			int[] right=new int[numberOfElements];
			int[] equal=new int[numberOfElements];
			int leftC=0;
			int rightC=0;
			int equalC=0;
			
			for(int i=0;i<numbers.length;i++){
				if(numbers[i]==numbers[0]){
					equal[equalC++]=numbers[i];
				}else if(numbers[i]>numbers[0]){
					right[rightC++]=numbers[i];
				}else{
					left[leftC++]=numbers[i];
				}
			}
			
			for(int i=0;i<leftC;i++){
				System.out.print(left[i]+" ");
			}
			for(int i=0;i<equalC;i++){
				System.out.print(equal[i]+" ");
			}
			for(int i=0;i<rightC;i++){
				System.out.print(right[i]+" ");
			}
			System.out.println();
		}catch(Exception ex){ex.printStackTrace();}
	}

}
