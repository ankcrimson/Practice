package ctpi;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class ParenthesisCombinations {
    //    Map<Integer, Set<String>> memo = new HashMap();
//
//    public Set<String> findParens(int n) {
//        if (n == 0) {
//            return Set.of();
//        }
//        if (n == 1) {
//            return Set.of("()");
//        }
//        Set<String> result = new HashSet<>();
//        Set<String> subResults = memo.containsKey(n - 1) ? memo.get(n - 1) : findParens(n - 1);
//        for (String s : subResults) {
//            result.add("()" + s);
//            result.add(s + "()");
//            result.add("(" + s + ")");
//        }
//        memo.put(n, result);
//        return result;
//    }
    public List<String> findParens(int n) {
        List<String> result = new LinkedList();
        char[] arr = new char[2 * n];
        addParens(result, arr, 0, n, n);
        return result;
    }

    public void addParens(List<String> result, char[] chars, int index, int left, int right) {
        if (right < left) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(new String(chars));
            return;
        }
        if (left > 0) {
            chars[index] = '(';
            addParens(result, chars, index + 1, left - 1, right);
        }
        if (right > 0) {
            chars[index] = ')';
            addParens(result, chars, index + 1, left, right - 1);
        }
        return;
    }

    @Test
    public void test() {
        for (int i = 0; i <= 19; i++) {
            Instant st = Instant.now();
            List<String> result = findParens(i);
//            System.out.println(result);
            Instant end = Instant.now();
            System.out.println("time taken= " + (end.toEpochMilli() - st.toEpochMilli()) + " ms for i=" + i);
        }
    }


}
