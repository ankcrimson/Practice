package hr.algos;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class Eleven_FindDigits {

	static public long solve(long n) {
		long count=0;
		long tmp=n;
		while(tmp>0) {
			int div=(int)tmp%10;
			tmp/=10;
			if(div!=0&&n%div==0)
				count++;
		}
		return count;
		
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(solve(n));
        }
    }
	
	@Test
	public void test() {
		Assert.assertEquals(2, solve(12));
		Assert.assertEquals(3, solve(1012));
	}
}
