
public class MaxCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="aabccccdDd   	Dd".toUpperCase().replaceAll(" ","").replaceAll("\t", "");
		byte[] arr=str.getBytes();
		int[] counts=new int[26];
		byte a=(byte)'A';
		int max=0;
		int maxInd=0;
		for(byte ch:arr)
		{
			counts[ch-a]++;
			if(counts[ch-a]>max)
			{
			max=counts[ch-a];
			maxInd=ch-a;
			}
		}
		System.out.println(((char)(maxInd+65))+","+max);
	}

}
