package ctci;

import org.junit.jupiter.api.Test;

public class BitFlips{
    public int countFlips(int a, int b){
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        int count=0;
        while(a!=0||b!=0){
            if((a&1) != (b&1)){
                count++;
            }
            a = a>>>1;
            b=b>>>1;
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(countFlips(29,15));
    }
}
