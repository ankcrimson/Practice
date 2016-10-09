package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	
	
	public static boolean isBalanced(String expression) {
	    byte[] bytes = expression.getBytes();
	    Stack<Byte> byteStack = new Stack<>();
 	    for(byte b:bytes){
 	    	if(b=='(' || b=='{' || b=='['){
 	    		byteStack.push(b);
 	    	}
 	    	if(b==')' || b=='}' || b==']'){
 	    		if(byteStack.isEmpty()){
 	    			return false;
 	    		}
 	    		byte popped = byteStack.pop();
 	    		if(b==')'&& popped!='(' || b=='}'&& popped!='{' || b==']'&& popped!='['){
 	    			return false;
 	    		}
 	    	}
	    }
		return byteStack.isEmpty();
    }
 
   public static void main(String[] args) throws Exception {
       
	   try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
		   int t = Integer.parseInt(br.readLine());
		   for(int a0 = 0; a0 < t; a0++) {
	           String expression = br.readLine();
	           boolean answer = isBalanced(expression);
	           if(answer)
	               System.out.println("YES");
	           else System.out.println("NO");
	       }
	   }
	   
	   
   }

}
