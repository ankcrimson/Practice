package ctci;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class LongestSequenceOf1s {

    public int flipBitLongestSequenceLength( long number){
        List<Integer> freq=new LinkedList();

        boolean firstOne=(number & 1) == 1;
        boolean ones=firstOne;
        int cnt=0;
        while(number!=0){
            if(!ones){
                if((number&1) == 1){

                    freq.add(cnt);
                    cnt=1;
                    ones=true;
                }else{
                    cnt++;
                }
            }else{
                if((number&1) == 1){
                    cnt++;
                }else{

                    freq.add(cnt);
                    cnt=1;
                    ones=false;
                }
            }
            number = number >>> 1;
        }
        freq.add(cnt);

        boolean currOne = firstOne;
        int maxSum=0;
        System.out.println(freq+""+firstOne);
        for(int i=0;i<freq.size();i++){
            if(currOne){
                currOne=false;
                maxSum=Math.max(maxSum,freq.get(i));

            }else{
                currOne=true;
                int next=freq.size()>i+1?freq.get(i+1):0;
                int prev=i>0?freq.get(i-1):0;
                maxSum=Math.max(maxSum,prev+1+next);
            }
        }
        return maxSum;
    }

    @Test
    public void test(){
        System.out.println(flipBitLongestSequenceLength(0b111101110111));
    }
}
