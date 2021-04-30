package ctci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MagicIndex {
    public int findMagicIndex(int[] arr){
        if(arr.length==0){
            return -1;
        }
        return findQuickMagicIndex(0,arr.length,arr);
    }

    public int findQuickMagicIndex(int start, int end, int[] arr){
        if(end<start){
            return -1;
        }
        int currIndex=(start+end)/2;
        if (arr[currIndex]==currIndex) {
            return currIndex;
        }
        if(arr[currIndex]>currIndex){
            return findQuickMagicIndex(currIndex+1,end,arr);
        } else {
            return findQuickMagicIndex(start, currIndex-1,arr);
        }

    }

    @Test
    public void test(){
        Assertions.assertEquals(2,findMagicIndex(new int[]{-5,-3,2,5}));
        Assertions.assertEquals(-1,findMagicIndex(new int[]{-5,-3,1,2,5}));
        Assertions.assertEquals(1,findMagicIndex(new int[]{1,1,1,1,1,1,1,1,1,1,1}));
        Assertions.assertEquals(2,findMagicIndex(new int[]{-10,-5,2,2,2,3,4,7,9,12,13}));
        int[] nums=new int[]{1,2};
//        List<int[]> nums1 = List.of(nums);
//        List<int[]> ints = Arrays.asList(nums);
    }
}
