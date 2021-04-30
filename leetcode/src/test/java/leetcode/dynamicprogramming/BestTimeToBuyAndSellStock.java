package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(price - min, profit);
        }
        return profit;
    }

    @Test
    public void test() {
        Assertions.assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assertions.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
        Assertions.assertEquals(2, maxProfit(new int[]{7, 6, 4, 3, 1, 3}));
        Assertions.assertEquals(0, maxProfit(new int[]{}));

    }
}
