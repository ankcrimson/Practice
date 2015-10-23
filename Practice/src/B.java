import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class B_1{
	
	int c=0;
	long l=0;
	int pos=0;
	long output;
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public long getL() {
		return l;
	}
	public void setL(long l) {
		this.l = l;
	}
	public long getOutput() {
		return output;
	}
	public void setOutput(long output) {
		this.output = output;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return output+"";
	}
}

public class B {
public static final int range=26;
    

public static void main(String args[] ) throws Exception {
InputStream is=new FileInputStream("b1");
BufferedReader br = new BufferedReader(new InputStreamReader(is));
Scanner s=new Scanner(br);
long[][] arr=new long[range][range];
	for(int i=0;i<range;i++)
	{
		for(int j=0;j<range;j++)
		{
			arr[i][j]=s.nextInt();
		}
		s.nextLine();
	}

	
	
	//transpose(arr);
	
	int t=s.nextInt();
	s.nextLine();

	Map<Long,B_1> qns=new HashMap<Long,B_1>();
	//Map<Integer,Long> qq=new HashMap<Integer,Long>();
//Set<B_1> tmpset=new HashSet<B_1>();
	long max=0;
	for(int i=0;i<t;i++)
	{
		String str=s.nextLine();
		String[] nums=str.split(" ");
		
		int c=(nums[0]).getBytes()[0];
		long l=Long.parseLong(nums[1]);
		c=c-'a';
		if(l>max)
			max=l;
		B_1 b1=new B_1();
		b1.setC(c);
		b1.setL(l);
		b1.setPos(i);;
		qns.put(l, b1);
		//qq.put(i, l);
	}
	
	long[][] arr2=arr;
	
	for(long j=2;j<=max;j++)
	{
		if(qns.containsKey(j))
		{
			long sum=0;
			int c=qns.get(j).getC();
		//	System.out.println("c=>"+c);
			for(int q=0;q<range;q++)
			{
				sum+=arr2[q][c];
		//		System.out.println(arr2[q][c]);
			}
			//System.out.println("op:"+sum%1000000007);
			qns.get(j).setOutput(sum%1000000007);
		}
	/*	System.out.println("-----------");
		for(long[] a1:arr2)
		{
			for(long a2:a1)
			{
				System.out.print(a2+" ");
			}
			System.out.println();
		}
		System.out.println("-----------");
	*/	arr2=matmul(arr2,arr);
		
	}

//System.out.println(qns);
	
Collection<B_1> vals=qns.values();

	for(int i=0;i<t;i++)
	{
Iterator<B_1> it=vals.iterator();
while(it.hasNext())
{
	B_1 curr=it.next();
	if(curr.getPos()==i)
	{
		System.out.println(curr.output);
		break;
	}
}
		
	}
	
		
    }
    public static long[][] matmul(long[][] arr,long[][] base)
    {
    	long[][] arr2=new long[range][range];
    	for(int i=0;i<range;i++)
    	{
    		for(int j=0;j<range;j++)
    		{
    			for(int k=0;k<range;k++)
        		{
        		arr2[i][j]+=(arr[i][k]*base[k][j])%1000000007;
        		
        			
        		}
    		}
    	}
    	
    	
    	/*
    	System.out.println("-----------");
		for(long[] a1:arr2)
		{
			for(long a2:a1)
			{
				System.out.print(a2+" ");
			}
			System.out.println();
		}
		System.out.println("-----------");
		*/
    	
    	return arr2;
    }

static public void transpose(long[][] arr)
{
	for(int i=0;i<range;i++)
	{
		for(int j=i;j<range;j++)
		{
			long tmp=arr[i][j];
			arr[i][j]=arr[j][i];
			arr[j][i]=tmp;
		}
	}
}

}
