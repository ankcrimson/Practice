package ctci;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class StackBox{
    int l;
    int w;
    int h;
    public StackBox(int l, int w, int h){
        this.l=l;
        this.w=w;
        this.h=h;
    }
}


public class StackOfBoxes {
    public int getMaxHeightOfStack(List<StackBox> boxes){
        int height=0;
        Collections.sort(
                boxes,
                (b1,b2) -> b2.h - b1.h
        );

        for(StackBox s:boxes){
            System.out.println(s.l+","+s.w+","+s.h);
        }

        return getMaxHeightOfStack(boxes,null,0);
    }

    public boolean canFitOnTop(StackBox lower, StackBox heigher){
        return lower.l>=heigher.l && lower.h>=heigher.h && lower.w >= heigher.w;
    }

    public int getMaxHeightOfStack(List<StackBox> boxes,StackBox bottom, int index){
        if(index>=boxes.size()){
            return 0;
        }
        StackBox curr=boxes.get(index);
        int heightWithBox=0;
        if(bottom==null||canFitOnTop(bottom,curr)){
            heightWithBox=getMaxHeightOfStack(boxes,curr,index+1);
            heightWithBox+=curr.h;
        }

        int heightWithoutBox=getMaxHeightOfStack(boxes,bottom,index+1);

        return Math.max(heightWithBox,heightWithoutBox);
    }

    @Test
    public void test(){
        System.out.println("maxHeight: "+getMaxHeightOfStack(
                new LinkedList<>( List.of(
                        new StackBox(3,2,3),
                        new StackBox(2,2,2),
                        new StackBox(1,5,4),
                        new StackBox(1,5,4),
                        new StackBox(1,5,4),
                        new StackBox(1,5,4),
                        new StackBox(1,5,4),
                        new StackBox(1,5,4),
                        new StackBox(1,5,4),
                        new StackBox(1,5,4)
                ))
        ));
    }
}
