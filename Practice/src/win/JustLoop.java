package win;
import java.util.ArrayList;
import java.util.List;


public class JustLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long lim=1000000000000l;
		//long lim=100l;
		List<Long> pms=new ArrayList<Long>();
		pms.add(2l);
		long x=0;
		for(long i=3;i<=lim;i+=2)
		{
			x++;
		}
		System.out.println(pms.size());
	}

}
