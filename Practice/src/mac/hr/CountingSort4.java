package mac.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
//https://www.hackerrank.com/challenges/countingsort2
public class CountingSort4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in, "UTF-8"))){
			int size=Integer.parseInt(br.readLine());
			int[] arr=new int[100];
			StringBuilder[] strings=new StringBuilder[100];
			for(int i=0;i<size;i++){
				String[] keys=br.readLine().split(" ");
				int pos=Integer.parseInt(keys[0]);
				if(i<size/2){
					keys[1]="-";
				}
				if(strings[pos]==null)
					strings[pos]=new StringBuilder(keys[1]);
				else
					strings[pos].append(" "+keys[1]);
			}
			StringBuilder answer=new StringBuilder();
			for(int i=0;i<100;i++){
				if(strings[i]!=null)
				answer.append(strings[i]+" ");
			}
			System.out.println(answer);
		}catch(Exception ex){ex.printStackTrace();}
	}

}
