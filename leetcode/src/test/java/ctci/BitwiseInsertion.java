package ctci;

import org.junit.jupiter.api.Test;

public class BitwiseInsertion {
    public int insertBits(int n, int m, int i, int j){
        int numbersInEnd = -1 >> 32-j;
        numbersInEnd = numbersInEnd & n;
        numbersInEnd = numbersInEnd >> (j-i);
        int maskForStart = -1 <<j;
        n = maskForStart & n;
        n = n | (m<<i);
        n = n | numbersInEnd;
        return n;
    }

    @Test
    public void test(){
        int result = insertBits(0b10000001,0b1001,1,4);
        System.out.println();
        System.out.printf(Integer.toBinaryString(result));
        System.out.println();
    }

}
