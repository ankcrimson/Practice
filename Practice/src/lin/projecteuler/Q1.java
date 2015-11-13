package lin.projecteuler;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum=0;
for(int i=1;i<1000;i++)
    {
	if(i%3==0||i%5==0)
		sum+=i;
    }
System.out.println(sum);
	}

}
