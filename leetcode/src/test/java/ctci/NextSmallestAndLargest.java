package ctci;

import org.junit.jupiter.api.Test;

public class NextSmallestAndLargest{

    public int getNext(int n){
        int c1=0,c0=0;
        int c=n;
        while(c!=0 && (c&1)==0){
            c=c>>>1;
            c0++;
        }

        while(c!=0 && (c&1)==1){
            c1++;
            c=c>>>1;
        }

        int p = c0+c1;
//        System.out.println(c0+", "+c1+", "+p);
        if(p>32||c1>31){
//            System.out.println("error");
            return -1;
        }

        n |= 1 << p;
        n &= ~((1 << p)-1);
        n |= ((1<<c1-1)-1);
        return n;
    }

    public int getPrev(int n){
        int c=n;
        int c1=0,c0=0;
        while((c&1)==1 && c!=0){
            c1++;
            c=c>>>1;
        }
        while((c&1)==0 && c!=0){
            c0++;
            c=c>>>1;
        }
        int p=c0+c1;
        n &= ~(1<<p);
        n &= ~((1<<p)-1);

        n |= ((1<<c1+1)-1)<<c0-1;

        return n;
    }

    public int[] flipBit(int n){
        return new int[]{getPrev(n),getNext(n)};
    }

    @Test
    public void testNext(){
//        System.out.println(Integer.toBinaryString(flipBit(0b010001)[1]));
//        System.out.println(Integer.toBinaryString(flipBit(0b011000)[1]));
//        System.out.println(Integer.toBinaryString(flipBit(-2)[1]));
//        System.out.println(Integer.toBinaryString(flipBit(-1)[1]));

        System.out.println(Integer.toBinaryString(flipBit(0b010001)[0]));
        System.out.println(Integer.toBinaryString(flipBit(0b011001)[0]));
        System.out.println(Integer.toBinaryString(flipBit(-1)[0]));
    }
}
