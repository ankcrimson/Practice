package tmp;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=9;
		int len=1;
		while(i>1)
		{
			if(i%2==0)
				i/=2;
			else
				i=3*i+1;
			len++;
			//System.out.println(i);
		}
		System.out.println(len+1);
	}

}
