package leetcode.contest.march;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Second {
    public int reinitializePermutation(int n) {
        int ops = 0;
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        boolean cond = false;
        while (!cond) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[(int) i / 2];
                } else {
                    arr[i] = perm[(int) ((n / 2) + ((i - 1) / 2))];
                }
            }
            perm = arr;
            ops++;

            cond = true;
            for (int i = 0; i < n; i++) {
                if (perm[i] != i) {
                    cond = false;
                    break;
                }
            }
        }
        return ops;
    }

    @Test
    public void test() {
        Assertions.assertEquals(1, reinitializePermutation(2));
        Assertions.assertEquals(1, reinitializePermutation(1000));
    }

}
