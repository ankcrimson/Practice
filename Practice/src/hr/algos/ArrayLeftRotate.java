package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayLeftRotate {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n,d;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nd = br.readLine().split(" ");
		
		d=Integer.parseInt(nd[1]);
		String[] arr = br.readLine().split(" ");
		StringBuffer answer = new StringBuffer();
		n=arr.length;
		String tmp = arr[0];
		for(int i = d;i<n;i++){
			answer.append(arr[i]).append(" ");
		}
		for(int i=0;i<d;i++){
			answer.append(arr[i]).append(" ");
		}
		System.out.println(answer);
	}

}
