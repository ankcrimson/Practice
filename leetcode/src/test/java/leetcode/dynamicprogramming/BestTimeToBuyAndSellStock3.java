package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BestTimeToBuyAndSellStock3 {


    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int leftMin = prices[0], rightMax = prices[prices.length - 1];
        for (int i = 1, j = prices.length - 2; i < prices.length; i++, j--) {
            leftMin = Math.min(prices[i], leftMin);
            left[i] = Math.max(left[i - 1], prices[i] - leftMin);
            rightMax = Math.max(rightMax, prices[j]);
            right[j] = Math.max(right[j + 1], rightMax - prices[j]);
        }

        Arrays.stream(left).forEach(x -> System.out.print(x + ", "));
        System.out.println();
        Arrays.stream(right).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        int max = 0;
        for (int i = 0; i < left.length; i++) {
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }

    @Test
    public void test() {
        Assertions.assertEquals(6, maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        Assertions.assertEquals(69, maxProfit(new int[]{3, 3, 5, 0, 0, 30, 1, 40}));
        Assertions.assertEquals(4, maxProfit(new int[]{1, 2, 3, 4, 5}));
        Assertions.assertEquals(5, maxProfit(new int[]{1, 4, 2, 4}));
        Assertions.assertEquals(3, maxProfit(new int[]{1, 4, 2}));
        Assertions.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
        Assertions.assertEquals(0, maxProfit(new int[]{1}));
        Assertions.assertEquals(2, maxProfit(new int[]{2, 1, 2, 0, 1}));
        Assertions.assertEquals(7, maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
        Assertions.assertEquals(13, maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));

    }
}
