package others;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetsPractice {

    @Test
    public void test() {
        Set s1 = new HashSet();
        Set s2 = new HashSet();
        s1.addAll(Arrays.asList(1, 2, 3));
        s2.addAll(Arrays.asList(3, 4, 5));
        System.out.println("s1=" + s1);
        System.out.println("s2=" + s2);
        Set s3 = new HashSet();
        s3.addAll(s1);
        s3.removeAll(s2);
        System.out.println("s2 removed " + s3);
        Set s4 = new HashSet();
        s4.addAll(s1);
        s4.retainAll(s2);
        System.out.println("s2 retained " + s4);
    }
}
