package ctci;

import org.junit.jupiter.api.Test;

public class DrawLineMonoChrome {

    public byte[] drawLine(byte[] screen, int width, int x1,int x2, int y){

        int yMaskLoc = y%8;
        int yMaskByte = y/8+1;

        int startFullByte = width*(x1+1);
        int endFullByte = width*(x2-1);
        // byte[] fullLine = (x2-x1>0)?getFullLine(width/8):new byte[0];
        for(int i=startFullByte;i<=endFullByte;i++){
            screen[i]=0xF;
        }
        byte maskStart = (byte) ((1 << (yMaskLoc+1))-1);
        screen[startFullByte-1]=maskStart;
        screen[endFullByte+1]=(byte)(~maskStart);

        return screen;
    }

    @Test
    public void test(){
        byte[] screen=new byte[160];
        int width=2;
        byte[] result = drawLine(screen,8*width,2,5,9);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<width;j++){
                System.out.print(Integer.toBinaryString(result[i*width+j]));
            }
            System.out.println();
        }
    }
}
