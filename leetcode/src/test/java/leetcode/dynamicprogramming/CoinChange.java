package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/coin-change/
public class CoinChange {
//    BFS - 118ms, 40.9MB
//    public int cChange(int[] coins, List<int[]> amounts, Set<Integer> nums) {
//
//        //pop
//        int[] currAmtAndLevel = amounts.get(0);
//        int currLevel = currAmtAndLevel[1] + 1;
//        amounts.remove(0);
//
//        if (currAmtAndLevel[0] < 0) {
//            return -1;
//        }
//
//        int minLevel = Integer.MAX_VALUE;
//        for (int c : coins) {
//            int nextAmt = currAmtAndLevel[0] - c;
//            if (nextAmt == 0) {
//                return currLevel;
//            }
//            //add to the end
//            if (!nums.contains(nextAmt) && nextAmt > 0) {
//                nums.add(nextAmt);
//                amounts.add(new int[]{nextAmt, currLevel});
//            }
//        }
//        if (amounts.size() == 0) {
//            return -1;
//        }
//        int result1 = cChange(coins, amounts, nums);
//        if (result1 > 0) {
//            minLevel = Math.min(minLevel, result1);
//        }
//        return (minLevel == Integer.MAX_VALUE) ? -1 : minLevel;
//
//    }
//
//    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//        if (amount == 0) {
//            return 0;
//        }
//        List<int[]> amounts = new LinkedList<>();
//        amounts.add(new int[]{amount, 0});
//        return cChange(coins, amounts, new HashSet<>());
//    }


    //other solution - DP
//    12ms, 38.2MB
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        int[] amounts = new int[amount + 1];
        amounts[0] = Integer.MAX_VALUE;
        for (short i = 1; i <= amount; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c > 0 && amounts[i - c] != Integer.MAX_VALUE) {
                    minValue = Integer.min(minValue, amounts[i - c] + 1);
                } else if (i - c == 0) {
                    minValue = 1;
                    break;
                }
            }
            amounts[i] = minValue;
        }
        return amounts[amount] == Integer.MAX_VALUE ? -1 : amounts[amount];
    }

    @Test
    public void test() {
        Assertions.assertEquals(3, coinChange(new int[]{1, 2, 5}, 11));
        Assertions.assertEquals(2, coinChange(new int[]{2, 3}, 4));
        Assertions.assertEquals(-1, coinChange(new int[]{3}, 4));
        Assertions.assertEquals(2, coinChange(new int[]{1, 2147483647}, 2));
        Assertions.assertEquals(20, coinChange(new int[]{1, 2, 5}, 100));
        Assertions.assertEquals(4, coinChange(new int[]{1, 2, 5, 10}, 18));
        Assertions.assertEquals(-1, coinChange(new int[]{2}, 3));
    }
}
