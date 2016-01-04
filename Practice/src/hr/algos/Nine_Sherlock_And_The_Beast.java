package hr.algos;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class Nine_Sherlock_And_The_Beast {

	public static String solve(int n) {
	StringBuffer result=new StringBuffer();
	int tmp=n;
	int threes=0;
	int fives=0;
	
	while(tmp%3!=0) {
		fives++;
		tmp-=5;
		if(tmp<0) return "-1";
	}
	threes=tmp/3;
	
	for(int i=0;i<threes;i++) result.append("555");
	for(int i=0;i<fives;i++) result.append("33333");
	
	return result.toString();
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
		//Assert.assertEquals("-1", solve(100000));
		Assert.assertEquals("55555533333", solve(11));
		Assert.assertEquals("33333", solve(5));
		Assert.assertEquals("555", solve(3));
		Assert.assertEquals("-1", solve(1));
		
	}

}
