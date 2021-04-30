package ctci;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class TowerOfHanoi{

    int numberOfSteps=0;

    public void move(Stack<Integer> start, Stack<Integer> buffer, Stack<Integer> end){
        if(start.isEmpty()){
            return;
        }
        move(start.size(),start,buffer,end);
    }

    public void move(int num, Stack<Integer> start, Stack<Integer> buffer, Stack<Integer> end){
        numberOfSteps++;
        if(num==1){
            int curr=start.pop();
            end.push(curr);
            return;
        }
        move(num-1,start,end,buffer);
//        move(1,start,buffer,end);
        int curr=start.pop();
        end.push(curr);
        move(num-1,buffer,start,end);
    }

    @Test
    public void test(){
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        Stack<Integer> s3=new Stack<>();
        int stackSize=30;
        for(int i=stackSize;i>0;i--){
            s1.push(i);
        }
        System.out.println("before");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        move(s1,s2,s3);
        System.out.println("after");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("Steps: "+numberOfSteps+" for tower of size "+stackSize);
    }
}