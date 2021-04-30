package ctci;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class FractionalToBinaryRepresentation {
    public String convert(double number){
        StringBuilder result=new StringBuilder(number==0?"0":"");
        short ctr=0;
        double zero=0.000000000000000000000000000000009d;
        while(number>=zero&&ctr<=32){
            number*=2;
            System.out.println(number);
            if(number>=1){
                result.append("1");
                number-=1;
            }else{
                result.append("0");
            }
            ctr++;
        }
//        System.out.println(number);
//        System.out.println(result);
        return number<=zero?result.toString():"ERROR";
    }

    @Test
    public void test1(){

        System.out.println(convert(0.72d));
        System.out.println(convert(0.8125d));

//        System.out.println(convert(0.72));
    }
}
