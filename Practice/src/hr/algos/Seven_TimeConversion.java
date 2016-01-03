package hr.algos;

import java.util.Scanner;

import org.junit.Test;

import com.sun.xml.internal.ws.developer.StreamingAttachmentFeature;

import static junit.framework.Assert.assertEquals;

public class Seven_TimeConversion {

	public static String solve(String time) {
		int hh=Integer.parseInt(time.substring(0,2));
        int mm=Integer.parseInt(time.substring(3,5));
        int ss=Integer.parseInt(time.substring(6,8));
        if(time.substring(8,9).equals("P")&&hh<12)
            hh+=12;
        else if(time.substring(8,9).equals("A")&&hh==12)
            hh=0;
        
        return String.format("%02d:%02d:%02d\n",hh,mm,ss);
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        System.out.println(solve(time));
    }
	
	@Test
	public void test() {
		assertEquals("19:05:45\n", solve("07:05:45PM"));
		assertEquals("07:05:45\n", solve("07:05:45AM"));
		assertEquals("00:05:45\n", solve("12:05:45AM"));
		assertEquals("12:05:45\n", solve("12:05:45PM"));
	}

}
