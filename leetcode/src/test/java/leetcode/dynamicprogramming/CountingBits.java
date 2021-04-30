package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/counting-bits/
public class CountingBits {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{0, 1};
        }
        int[] answer = new int[num + 1];
        //1,2,4,8,16
        //0 ->
        //1 -> 1
        //2 -> 1    ie 1+a[0] where index is i-2
        //3 -> 11   ie 1+a[1] where index is i-2
        //4 -> 100  ie 1+a[0] where index is i-4
        //7 -> 111  ie 1+a[3] where index is i-4
        //8 -> 1000 ie 1+a[0] where index is i-8
        //9 -> 1001 ie 1+a[1] where index is i-8
        //10 ->1010 ie 1+a[2] where index is i-8
        //15 ->1111 ie 1+a[7] where index is i-8
        //16 ->10000 ie 1+a[0] where index is i-16
        answer[0] = 0;
        answer[1] = 1;
        int changePoint = 1;
        int nextChangePoint = 2;
        for (int i = 2; i <= num; i++) {
            if (i == nextChangePoint) {
                //next change at 4
                changePoint = nextChangePoint;
                nextChangePoint *= 2;
            }
            answer[i] = 1 + answer[i - changePoint];
        }
        return answer;
    }

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{0, 1, 1}, countBits(2));
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, countBits(5));
        Assertions.assertArrayEquals(new int[]{0}, countBits(0));
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2}, countBits(17));
    }
}
