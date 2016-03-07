package lin.projecteuler;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
long sum=0;
int a=1,b=1,c=0;
while(c<4000000)
{
	if(c%2==0)
		sum+=c;
	//System.out.println(c);
	c=a+b;
	a=b;
	b=c;
	
	}
System.out.println(sum);
	}

}
