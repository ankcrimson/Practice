package ctpi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneOffStrings {
    //abcd abc - t
//abc abcd - t
//abce abcd - t
//eabf abcd - f

//assumptions -
// lower case english chars

    /*

     */

    //abcd abc - t
//eabf abcd - f
    public boolean isStringOneOrZeroEditAway(String s1, String s2) {
        int[] a1 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 'a']++;
        }
        // [1,1,1,1]
        //[1,1,0,0,1,1]
        for (int i = 0; i < s2.length(); i++) {
            a1[s2.charAt(i) - 'a']--;
        }
        // [0,0,0,1]
        //[0,0,-1,-1,1,1]
        int positives = 0, negatives = 0;
        for (int i = 0; i < 26; i++) {
            if (a1[i] > 0) {
                positives += a1[i];
            } else {
                negatives -= a1[i];
            }
        }
        //p=1 n=0
        //p=
        if (positives < 2 && negatives < 2) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        Assertions.assertTrue(isStringOneOrZeroEditAway("abcd", "abcd"));
        Assertions.assertTrue(isStringOneOrZeroEditAway("abcd", "abc"));
        Assertions.assertTrue(isStringOneOrZeroEditAway("abc", "abcd"));
        Assertions.assertTrue(isStringOneOrZeroEditAway("abce", "abcd"));
        Assertions.assertFalse(isStringOneOrZeroEditAway("zbce", "abcd"));
    }
}
