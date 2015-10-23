package com.hr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Euler_11 {

	 public static void main(String[] args) throws Exception {
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int[][] arr=new int[20][20];
		 for(int i=0;i<20;i++)
		 {
			 String[] vals=br.readLine().split(" ");
			 for(int j=0;j<20;j++)
			 {
				 arr[i][j]=Integer.parseInt(vals[j]);
			 }
		 }
		 //vals read
		 int max=0;
		 for(int i=0;i<20;i++)
		 {
			 for(int j=0;j<20;j++)
			 {
				 if(i<=16)
				 {
					 int x=arr[i][j]*arr[i+1][j]*arr[i+2][j]*arr[i+3][j];
					 if(x>max)max=x;
				 }
				 if(j<=16)
				 {
					 int x=arr[i][j]*arr[i][j+1]*arr[i][j+2]*arr[i][j+3];
					 if(x>max)max=x;
				 }
				 if(i<=16&&j<=16)
				 {
					 int x=arr[i][j]*arr[i+1][j+1]*arr[i+2][j+2]*arr[i+3][j+3];
					 if(x>max)max=x;
				 }
				 if(i>=3&&j<=16)
				 {
					 int x=arr[i][j]*arr[i-1][j+1]*arr[i-2][j+2]*arr[i-3][j+3];
					 if(x>max)max=x;
				 }
			 }
		 }
		 System.out.println(max);
		 
	}
}
