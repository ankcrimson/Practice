package com.euler;

public class LargestPallendrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 999;
		int b = 999;

		long max = 0;

		while (a > 100) {
			long num = a * b;
			if (checkPallendrome(num)) {
				if (num > max)
					max = num;
			}
			if (b >= 100)
				b--;
			else {
				a--;
				b = 999;
			}
		}
		System.out.println(max);
	}

	public static boolean checkPallendrome(long num) {
		String a = num + "";
		String b = new StringBuffer(num + "").reverse().toString();
		if (a.equals(b))
			return true;
		return false;
	}
}
