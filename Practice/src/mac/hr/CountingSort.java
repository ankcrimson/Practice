package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")))){
			br.readLine();//n
			String[] numbersStr=br.readLine().split(" ");
			int[] numbers=new int[100];
			for(int i=0;i<numbersStr.length;i++){
				numbers[Integer.parseInt(numbersStr[i])]++;
			}
			for(int n:numbers){
			System.out.print(n+" ");	
			}
			System.out.println();
		}catch(Exception ex){ex.printStackTrace();}
	}

}
