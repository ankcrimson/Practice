package hr.algos;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class One_SolveMeFirst {

	public static int solver(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try(
				InputStreamReader isr=new InputStreamReader(System.in);
				BufferedReader br=new BufferedReader(isr);
				) {
			int a=Integer.parseInt(br.readLine());
			int b=Integer.parseInt(br.readLine());
			System.out.println(solver(a, b));
		}
		
	}
	@Test
	public void test() {
		assertEquals(5, solver(3, 2));
	}

}
