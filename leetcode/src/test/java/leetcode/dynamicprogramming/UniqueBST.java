package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/unique-binary-search-trees/
public class UniqueBST {
    public int numTrees(int n) {
        int[] trees = new int[n + 1];
        trees[0] = trees[1] = 1;

        for (int i = 2; i < n + 1; i++) {
//            calc for tree with i nodes with 0,1 known
            int total = 0;
            for (int j = 0; j < i; j++) {
                total += trees[i - j - 1] * trees[j];
            }
            System.out.println(total);
            trees[i] = total;
        }
        return trees[n];
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, numTrees(2));
        Assertions.assertEquals(5, numTrees(3));
        Assertions.assertEquals(14, numTrees(4));
    }
}
