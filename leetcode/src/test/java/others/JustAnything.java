package others;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class JustAnything {

    @Test
    public void testStringFormat() {
//        String s = String.format("sc=%d", 20);
        String s = String.format("sc=%d", 200);
        System.out.println(s);
    }

    @Test
    public void testMod() {
        System.out.println(-2 % 2);
        System.out.println(2 % 2);
        System.out.println(-1 % 2);
        System.out.println(1 % 2);
        System.out.println(-3 % 2);


//        System.out.println(11 & 10);
    }

    @Test
    public void subStr() {
        System.out.println("1234567".substring(5));
        Optional.of(null);
    }
}
