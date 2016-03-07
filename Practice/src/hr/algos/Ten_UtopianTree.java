package hr.algos;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class Ten_UtopianTree {
	
	public static int solve(int n) {
		int result=1;
		
		for(int i=0;i<n;i++) {
			if(i%2==0)
				result*=2;
			else
				result+=1;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(solve(n));
        }
    }
	
	@Test
	public void test() {
		Assert.assertEquals(1, solve(0));
		Assert.assertEquals(2, solve(1));
		Assert.assertEquals(7, solve(4));
		
	}
}
