package leetcode.contest.march;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class First {
    public int numDifferentIntegers(String word) {
        char[] arr = word.toCharArray();
        Set<Integer> nums = new HashSet<>();
        int num = 0;
        boolean prevNum = false;
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch <= '9' && ch >= 0) {
                num = num * 10 + ch - '0';
                prevNum = true;
                if (i == arr.length - 1) {
                    nums.add(num);
                }
            } else {
                if (prevNum) {
                    nums.add(num);
                }
                prevNum = false;
                num = 0;
            }
        }
//        System.out.println(nums);
        return nums.size();

    }

    @Test
    public void test() {
        Assertions.assertEquals(3, numDifferentIntegers("a123bc34d8ef34"));
        Assertions.assertEquals(2, numDifferentIntegers("leet1234code234"));
        Assertions.assertEquals(1, numDifferentIntegers("a1b01c001"));
        Assertions.assertEquals(1, numDifferentIntegers("00000"));
        Assertions.assertEquals(1, numDifferentIntegers("0"));
        Assertions.assertEquals(2, numDifferentIntegers("1_0"));
    }

}
