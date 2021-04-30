package ctci;

import org.junit.jupiter.api.Test;

public class BitwiseMul{
    public int multiply(int a, int b){
        int sum=0;
        while(b>0){
            if((b&1) == 1){
                sum+=a;
            }
            b=b>>1;
            a=a<<1;
        }
        return sum;
    }
    @Test
    public void test(){
        System.out.println(multiply(3,5));
    }
}
