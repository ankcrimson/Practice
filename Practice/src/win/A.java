package win;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for(int i=1;i<7;i++)
		//{
			//int a=(int)(8*Math.log(i));
			//if(a>i)
		boolean res=true;
		int i=2;
			do{
				System.out.println("n="+i);
				long a=(long)(64*i*Math.log(i));
				long b=(8*i*i);
				System.out.println("64nlogn="+a);
				System.out.println("8n^2="+b);
				//break;
				i++;
				res=a>b;
			}while(res);
		//}
	}

}
