package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerfectSquare {
    public int[] generateSquares(int n) {
        int num = Double.valueOf(Math.sqrt(n)).intValue();
        int[] squares = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            squares[i] = i * i;
        }
        return squares;
    }

    int findBfs(int[] squares, List<int[]> numList) {
        int n = numList.get(0)[0];
        int d = numList.get(0)[1];
        int sqrt = Double.valueOf(Math.sqrt(n)).intValue();
        if (n == 0) {
            return d;
        }
        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        int minDept = Integer.MAX_VALUE;
        for (int i = sqrt; i > 0; i--) {
            int remainingNum = n - squares[i];
            if (remainingNum == 0) {
                return d + 1;
            }
            numList.add(new int[]{remainingNum, d + 1});
        }
        numList.remove(0);
        return findBfs(squares, numList);
//        return minDept;
    }

    public int numSquares(int n) {
        int[] squares = generateSquares(n);

        List<int[]> numList = new LinkedList<>();
        numList.add(new int[]{n, 0});
        return findBfs(squares, numList);
    }

    @Test
    public void test() {
        assertEquals(3, numSquares(12));
        assertEquals(2, numSquares(13));
        assertEquals(1, numSquares(10000));
        assertEquals(0, numSquares(0));
    }

}
