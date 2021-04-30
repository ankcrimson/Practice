package ctci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class TripleStep {
    public BigInteger countSteps(int n){
        BigInteger[] steps=new BigInteger[4];
        steps[0]=BigInteger.valueOf(1);
        steps[1]=BigInteger.valueOf(2);
        steps[2]=BigInteger.valueOf(4);
        if(n==0){
            return BigInteger.valueOf(0);
        }
        if(n<4){
            return steps[n-1];
        }
        for(int i=4;i<=n;i++){
            steps[3]=steps[2].add(steps[1].add(steps[0]));
            steps[0]=steps[1];
            steps[1]=steps[2];
            steps[2]=steps[3];
        }
        return steps[3];
    }

    @Test
    public void test(){
        Assertions.assertEquals(BigInteger.valueOf(13),countSteps(5));
        System.out.println(countSteps(100000));
    }
}
