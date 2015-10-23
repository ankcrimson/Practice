package lin.projecteuler;

public class SpiralDiagonalSum {

	public static void main(String[] args) {
		int lim=1001;
		long sum=1;
		for(int i=3;i<=lim;i+=2)
		{
			long upper=i*i;
			sum+=upper;
			sum+=upper-(i-1);
			sum+=upper-2*(i-1);
			sum+=upper-3*(i-1);
		}
		System.out.println(sum);
	}

}
