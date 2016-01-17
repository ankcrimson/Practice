package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class Twelve_SherlockAndSquares {

	public static int solve(List<Integer> squares,int a, int b) {
		int count=0;
		for(int x:squares) {
			if(x>b) break;
			if(x>=a) count++;
			
		}
		return count;
	}
	
	public static void init(List<Integer> squares) {
		for(int i=1;;i++) {
			int square=i*i;
			if(square>1000000000) break;
			squares.add(square);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> squares=new LinkedList<>();
		init(squares);
		try(InputStreamReader isr=new InputStreamReader(System.in);
				BufferedReader br=new BufferedReader(isr);) {
			int t=Integer.parseInt(br.readLine());
			for(int i=0;i<t;i++) {
				String[] ab=br.readLine().split(" ");
				int a=Integer.parseInt(ab[0]);
				int b=Integer.parseInt(ab[1]);
				System.out.println(solve(squares, a, b));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void test() throws Exception {
		List<Integer> squares=new LinkedList<>();
		init(squares);
		Assert.assertEquals(2, solve(squares, 3, 9));
		Assert.assertEquals(0, solve(squares, 17, 24));
	}
	
}
