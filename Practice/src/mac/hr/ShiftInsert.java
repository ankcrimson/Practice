package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

//https://www.hackerrank.com/challenges/insertionsort1
public class ShiftInsert {

	public static void print(int[] numbers){
		for(int i:numbers){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")))){
			br.readLine();//n
			String[] numbersStr=br.readLine().split(" ");
			int[] numbers=new int[numbersStr.length];
			for(int i=0;i<numbersStr.length;i++){
				numbers[i]=Integer.parseInt(numbersStr[i]);
			}
			int tmp=numbers[numbers.length-1];
			for(int i=numbers.length-1;i>=0;i--){
				if(i>0&&tmp<numbers[i-1]){
					numbers[i]=numbers[i-1];
					print(numbers);
				}else{
					numbers[i]=tmp;
					print(numbers);
					break;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
