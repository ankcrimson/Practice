package lin.projecteuler;

public class FifthPowers {

	public static void main(String[] args) {
		long ans=0;
		for(int i=0;i<10;i++)
		for(int j=0;j<10;j++)
		for(int k=0;k<10;k++)
		for(int l=0;l<10;l++)
		for(int m=0;m<10;m++)
		for(int n=0;n<10;n++)
					{
			long sum=i*i*i*i*i+j*j*j*j*j+k*k*k*k*k+l*l*l*l*l+m*m*m*m*m+n*n*n*n*n;
			String x=""+i+j+k+l+m+n;
			String sumStr=""+sum;
			while(sumStr.length()<6)sumStr="0"+sumStr;
			if(x.equals(sumStr))
			{
				ans+=sum;
			}
				
		}
		System.out.println(ans-1);
	}

}
