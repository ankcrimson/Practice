package ctpi;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PermutationsOfString {

    Map<String, List<String>> lookup = new HashMap<>();

    public List<String> permutations(String str) {
        if (str.length() == 1) {
            return List.of(str);
        }
        List<String> result = new LinkedList();

        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            final char ch = sb.charAt(i);
            sb.deleteCharAt(i);
            String subStr = new String(sb);
            final List<String> subPermutations = lookup.containsKey(subStr) ? lookup.get(subStr) : permutations(subStr);
            sb.insert(i, ch);
            for (String sp : subPermutations) {
                result.add(ch + sp);
            }
        }
        lookup.put(str, result);
        return result;
    }

    @Test
    public void test() {
        for (int i = 0; i < 11; i++) {
            Instant st = Instant.now();
            permutations("abcdefghijklmnopqrstuvwxyz".substring(0, i));
            Instant end = Instant.now();
            System.out.println("time taken= " + (end.toEpochMilli() - st.toEpochMilli()) + " ms for i=" + i);
        }
    }

}
