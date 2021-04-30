package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecodeWays {


    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0 || chars[0] == '0') {
            return 0;
        }
        int countTillPrev2 = 1;
        int countTillPrev = 1; //as 0 is covered above so currChar>0
        for (int i = 1; i < chars.length; i++) {
            int countAtCurr = 0;
            int twoDigitNum = (chars[i - 1] - '0') * 10 + chars[i] - '0';

            if (twoDigitNum >= 10 && twoDigitNum <= 26) {
                if (chars[i] == '0') //10,20
                    countAtCurr = countTillPrev2;
                else
                    countAtCurr = countTillPrev2 + countTillPrev;
            } else {
                if (chars[i] == '0')
                    countAtCurr = 0;
                else
                    countAtCurr = countTillPrev;
            }
            countTillPrev2 = countTillPrev;
            countTillPrev = countAtCurr;

        }
        return countTillPrev;
    }


    @Test
    public void test() {
        DecodeWays decodeWays = new DecodeWays();
//        System.out.println(decodeWays.numDecodings("20261"));
//        System.out.println(decodeWays.numDecodings("20"));
//        Assertions.assertEquals(2, decodeWays.numDecodings("12"));
        Assertions.assertEquals(3, decodeWays.numDecodings("226"));
        Assertions.assertEquals(0, decodeWays.numDecodings("100"));
        Assertions.assertEquals(0, decodeWays.numDecodings("33306"));
//        System.out.println(decodeWays.numDecodings("220"));

        Assertions.assertEquals(0, decodeWays.numDecodings("0"));
        Assertions.assertEquals(0, decodeWays.numDecodings("06"));
        Assertions.assertEquals(1, decodeWays.numDecodings("2101"));
        Assertions.assertEquals(9, decodeWays.numDecodings("123123"));
//        Instant before = Instant.now();
//        Assertions.assertEquals(1836311903, decodeWays.numDecodings("11111111111111111111111111111111111111111111111111"));
//        Instant after = Instant.now();
//        System.out.println(after.toEpochMilli() - before.toEpochMilli());
//        Assertions.assertEquals(1836311903, decodeWays.numDecodings("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));

    }

    public int numDecodings2(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n2 = 1, n1 = 1;
        for (int i = 1; i < s.length(); ++i) {
            int n0 = s.charAt(i) == '0' ? 0 : n1;
            int num = s.charAt(i) - '0' + 10 * (s.charAt(i - 1) - '0');
            if (10 <= num && num <= 26) {
                n0 += n2;
            }
            n2 = n1;
            n1 = n0;
        }
        return n1;
    }

}
