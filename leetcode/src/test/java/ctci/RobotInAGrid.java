package ctci;

import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotInAGrid {
    public List<Point> getPath(boolean maze[][] ){
        if(maze==null||maze.length==0){
            return null;
        }

        List<Point> response=new ArrayList();
        Set<Point> badPoints=new HashSet<>();
        getPath(maze.length-1,maze[0].length-1,maze,badPoints,response);
        return response;
    }

    public boolean getPath(int r,int c,boolean[][] maze, Set<Point> bad, List<Point> response){
        if(r<0||c<0||!maze[r][c]){
            bad.add(new Point(r,c));
            return false;
        }

        if(r==0&&c==0
                || !bad.contains(new Point(r-1,c))&&getPath(r-1,c,maze,bad,response)
                ||!bad.contains(new Point(r,c-1))&&getPath(r,c-1,maze,bad,response)){
            response.add(new Point(r,c));
            return true;
        }
        bad.add(new Point(r,c));
        return false;
    }

    @Test
    public void test(){
        boolean[][] maze=new boolean[][]{
                {true,true,true},
                {true,false,true},
                {false,true,true},
                {false,true,true}
        };
        List<Point> path = getPath(maze);
        System.out.println(path);
    }
}
