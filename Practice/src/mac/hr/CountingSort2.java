package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
//https://www.hackerrank.com/challenges/countingsort2
public class CountingSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in, "UTF-8"))){
			br.readLine();//n
			String[] numbersStr=br.readLine().split(" ");
			int[] numbers=new int[100];
			for(int i=0;i<numbersStr.length;i++){
				numbers[Integer.parseInt(numbersStr[i])]++;
			}
			for(int i=0;i<100;i++){
			for(int j=0;j<numbers[i];j++){
				System.out.print(i+" ");
			}	
			}
			System.out.println();
		}catch(Exception ex){ex.printStackTrace();}
	}

}
