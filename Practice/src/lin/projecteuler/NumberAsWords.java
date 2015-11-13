package lin.projecteuler;

public class NumberAsWords {

	public static String tys(int i)
	{
		String ret="";
		switch(i)
		{
		case 2: return "Twenty";
		case 3: return "Thirty";
		case 4: return "Fourty";
		case 5: return "Fifty";
		case 6: return "Sixty";
		case 7: return "Seventy";
		case 8: return "Eighty";
		case 9: return "Ninty";
		
		}
		return ret;
	}
	
	public static String under20(int i)
	{
		String ret="";
		
		switch(i)
		{
		case 1: return "One";
		case 2: return "Two";
		case 3: return "Three";
		case 4: return "Four";
		case 5: return "Five";
		case 6: return "Six";
		case 7: return "Seven";
		case 8: return "Eight";
		case 9: return "Nine";
		case 10: return "Ten";
		case 11: return "Eleven";
		case 12: return "Twelve";
		case 13: return "Thirteen";
		case 14: return "Fourteen";
		case 15: return "Fifteen";
		case 16: return "Sixteen";
		case 17: return "Seventeen";
		case 18: return "Eighteen";
		case 19: return "Nineteen";
		};
		
		return ret;
	}
	
	public static String getWords(int i)
	{
		String retval="";
		
		if(i>99)
		{
			int tmp=i/100;
			retval+=under20(tmp)+"Hundred";
			i=i%100;
			if(i>0)retval+="And";
		}
		if(i<20)
			retval+=under20(i);
		else
		{
			retval+=tys(i/10)+under20(i%10);
		}
		return retval;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String val="";
		for(int i=1;i<1000;i++)
		{
			val+=getWords(i);
			System.out.println(getWords(i));
		}
		val+="OneThousand";
		System.out.println(val.length());
	}

}
