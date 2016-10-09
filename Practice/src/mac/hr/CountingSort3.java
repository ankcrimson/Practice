package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
//https://www.hackerrank.com/challenges/countingsort2
public class CountingSort3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in, "UTF-8"))){
			int size=Integer.parseInt(br.readLine());
			int[] arr=new int[100];
			for(int i=0;i<size;i++){
				String[] keys=br.readLine().split(" ");
				arr[Integer.parseInt(keys[0])]++;
			}
			int counter=0;
			for(int i=0;i<100;i++){
				counter+=arr[i];
				System.out.print(counter+" ");
			}
			System.out.println();
		}catch(Exception ex){ex.printStackTrace();}
	}

}
