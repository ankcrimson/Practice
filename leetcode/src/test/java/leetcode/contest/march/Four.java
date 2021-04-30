package leetcode.contest.march;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Four {

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 4) {
            return primeFactors;
        }
        long addition = primeFactors - 3;
        addition = addition * (addition + 1) / 2;
//        int num = 3;
//        for (int i = 3; i <= primeFactors; i++) {
//            num += i - 3;
//            num %= 1000000000;
//        }
        return (int) ((addition + 3) % 1000000000);
//        return num;
    }

    @Test
    public void test() {
        Assertions.assertEquals(6, maxNiceDivisors(5));
        Assertions.assertEquals(18, maxNiceDivisors(8));
        Assertions.assertEquals(729, maxNiceDivisors(18));
    }
}
