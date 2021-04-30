package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] maxTillNow = new int[nums.length];
        maxTillNow[0] = nums[0];
        maxTillNow[1] = nums[1];
        maxTillNow[2] = nums[0] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 2) {
                maxTillNow[i] = Math.max(nums[i] + maxTillNow[i - 2], nums[i] + maxTillNow[i - 3]);
            }
        }
        Arrays.stream(maxTillNow).forEach(x -> System.out.print(x + ", "));
        System.out.println();
        int max = 0;
        for (int m : maxTillNow) {
            max = Math.max(m, max);
        }
        return max;
    }


    @Test
    public void test() {
        Assertions.assertEquals(4, rob(new int[]{1, 2, 3, 1}));
        Assertions.assertEquals(12, rob(new int[]{2, 7, 9, 3, 1}));
        Assertions.assertEquals(4, rob(new int[]{2, 1, 1, 2}));
        Assertions.assertEquals(8, rob(new int[]{2, 1, 1, 2, 5}));
        Assertions.assertEquals(10, rob(new int[]{2, 5, 1, 2, 5}));
        Assertions.assertEquals(0, rob(new int[]{0, 0}));
        Assertions.assertEquals(0, rob(new int[]{0, 0, 0}));
        Assertions.assertEquals(0, rob(new int[]{}));
        Assertions.assertEquals(1, rob(new int[]{1}));

    }
}
