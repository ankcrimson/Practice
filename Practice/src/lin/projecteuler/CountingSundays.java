package lin.projecteuler;

public class CountingSundays {

	public static int daysinmonth(int mon,int year)
	{
		switch(mon)
		{
		case 1: return 31;
		case 2: if(year%400==0||(year%100!=0&&year%4==0))return 29; else return 28;
		case 3: return 31;
		case 4: return 30;
		case 5: return 31;
		case 6: return 30;
		case 7: return 31;
		case 8: return 31;
		case 9: return 30;
		case 10: return 31;
		case 11: return 30;
		case 12: return 31;
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int starty=1900;
		int startm=1;
		//int startd=1;
		int cnt=0;
		long start=0;
		
		while(starty<2001)
		{
			start+=daysinmonth(startm, starty);
			startm++;
			if(startm>12)
			{
				startm=1;
				starty++;
			}
			if(start%7==6)
				{
				if(starty>1900)
				cnt++;
				System.out.println("cal "+startm+" "+starty+" | head -3 | tail -1");
				}
		}
		System.out.println(cnt);
		
	}

}
