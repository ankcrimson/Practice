package ctci;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new LinkedList();
        result.add(new LinkedList());
        for(int num:nums){
            List<List<Integer>> currentSet=new LinkedList();
            for(List<Integer> resultItem: result){
                List<Integer> newItem=new LinkedList<>(resultItem);

                newItem.add(num);
                currentSet.add(newItem);
            }
            result.addAll(currentSet);
        }
        return result;
    }

    @Test
    public void test(){
        subsets(new int[]{});
        System.out.println(subsets(new int[]{1,2,3}));;
    }
}
