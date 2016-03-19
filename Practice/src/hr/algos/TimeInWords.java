package hr.algos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Test;

public class TimeInWords {


  public static String minToWords(int mm) {
    String retVal = "";

    if (mm > 19) {
      int tens = mm / 10;
      switch (tens) {
        case 2:
          retVal = "twenty ";
          mm = mm % 10;
          break;
        case 3:
          retVal = "thirty ";
          mm = mm % 10;
          break;
        case 4:
          retVal = "forty ";
          mm = mm % 10;
          break;
        case 5:
          retVal = "fifty ";
          mm = mm % 10;
          break;

      }
    }

    switch (mm) {
      case 1:
        retVal += "one";
        break;
      case 2:
        retVal += "two";
        break;
      case 3:
        retVal += "three";
        break;
      case 4:
        retVal += "four";
        break;
      case 5:
        retVal += "five";
        break;
      case 6:
        retVal += "six";
        break;
      case 7:
        retVal += "seven";
        break;
      case 8:
        retVal += "eight";
        break;
      case 9:
        retVal += "nine";
        break;
      case 10:
        retVal += "ten";
        break;
      case 11:
        retVal += "eleven";
        break;
      case 12:
        retVal += "twelve";
        break;
      case 13:
        retVal += "thirteen";
        break;
      case 14:
        retVal += "fourteen";
        break;
      case 15:
        retVal += "fifteen";
        break;
      case 16:
        retVal += "sixteen";
        break;
      case 17:
        retVal += "seventeen";
        break;
      case 18:
        retVal += "eighteen";
        break;
      case 19:
        retVal += "nineteen";
        break;
    }

    return retVal;
  }


  public static String solve(int h, int m) {
    String ans = "";
    String hr = "";
    if (m > 30)
      h++;

    hr = minToWords(h);// hour in words

    switch (m) {
      case 0:
        return hr + " o' clock";
      case 15:
        return "quarter past " + hr;
      case 30:
        return "half past " + hr;
      case 45:
        return "quarter to " + hr;
      default:
        if (m == 1)
          return minToWords(m).trim() + " minute past " + hr;
        else if (m < 30)
          return minToWords(m).trim() + " minutes past " + hr;
        else if (m == 59)
          return minToWords(60 - m).trim() + " minute to " + hr;
        else
          return minToWords(60 - m).trim() + " minutes to " + hr;
    }

  }

  public static void main(String[] args) {
    try (InputStreamReader inputStreamReader = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(inputStreamReader);) {
      int h = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      System.out.println(solve(h, m));
    } catch (Exception ex) {
    }
  }

  @Test
  public void testNumberConversion() {
    Assert.assertEquals("twelve", minToWords(12));
    Assert.assertEquals("twenty one", minToWords(21));
    Assert.assertEquals("fifty nine", minToWords(59));
  }

  @Test
  public void testfullLogic() {
    Assert.assertEquals("five o' clock", solve(5, 0));
    Assert.assertEquals("one minute past five", solve(5, 1));
    Assert.assertEquals("ten minutes past five", solve(5, 10));
    Assert.assertEquals("half past five", solve(5, 30));
    Assert.assertEquals("twenty minutes to six", solve(5, 40));
    Assert.assertEquals("quarter to six", solve(5, 45));
    Assert.assertEquals("thirteen minutes to six", solve(5, 47));
    Assert.assertEquals("twenty eight minutes past five", solve(5, 28));

  }



}
