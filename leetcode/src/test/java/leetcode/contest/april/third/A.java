package leetcode.contest.april.third;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class A {
    public String truncateSentence(String s, int k) {
        String[] strs = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < k; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(strs[i]);
        }
        return sb.toString();
    }


    public int[] findingUsersActiveMinutes(int[][] logs, int k) {

        int[] results = new int[k];
        Set<List<Integer>> logs2 = new HashSet<>();
        for (int[] e : logs) {
            logs2.add(List.of(e[0], e[1]));
        }
        Map<Integer, Integer> recordsPerUser = new HashMap<>();
        for (List<Integer> e : logs2) {
//            results[e.get(1) - 1]++;
            int userId = e.get(0);
            recordsPerUser.put(userId, recordsPerUser.getOrDefault(userId, 0) + 1);
        }
        recordsPerUser.values().forEach(v -> results[v - 1]++);
        return results;
    }

    //    https://leetcode.com/contest/weekly-contest-235/problems/minimum-absolute-sum-difference/
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] absDiffArr = new int[nums1.length];
        int[] absNSquareDiffArr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            absDiffArr[i] = diff;
            int minDiff = diff;
            for (int j = 0; j < nums1.length; j++) {
                int absDiff2 = Math.abs(nums1[j] - nums2[i]);
                if (minDiff > absDiff2) {
                    minDiff = absDiff2;
                }
            }
            absNSquareDiffArr[i] = minDiff;
        }

        int maxGap = 0;
        long result = 0;
        for (int i = 0; i < nums1.length; i++) {
            result %= 1000000007;
            maxGap = Math.max(maxGap, Math.abs(absDiffArr[i] - absNSquareDiffArr[i]));
            result += absDiffArr[i];
        }
        result -= maxGap;

        return (int) result % 1000000007;
    }

    @Test
    public void test() {
    }
}
