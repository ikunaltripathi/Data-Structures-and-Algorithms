package backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class printingPath {
    public static void main(String[] args) {
        boolean[][] maze = {{true,true, true}, {true,false, true},{true,true,true}};
//      System.out.println(printPath(3,3, ""));
//      System.out.println(printPathDiag(3,3, ""));
        System.out.println(printPathObstacles(0,0, maze, ""));
    }

    public static ArrayList<String> printPath(int m, int n, String P) {
        if (m ==1 && n==1) {
            ArrayList<String> al = new ArrayList<>();
            al.add(P);
            return al;
        }
        ArrayList<String> x = new ArrayList<>();
        if (m>0) {
            x.addAll(printPath(m - 1, n, "D" + P));
        }
        if (n>0) {
            x.addAll(printPath(m, n - 1, "R" + P));
        }
        return x;
    }

    public static ArrayList<String> printPathDiag(int m, int n, String P) {
        if (m ==1 && n==1) {
            ArrayList<String> al = new ArrayList<>();
            al.add(P);
            return al;
        }
        ArrayList<String> x = new ArrayList<>();
        if (m>0) {
            x.addAll(printPath(m - 1, n, "D" + P));
        }
        if (n>0) {
            x.addAll(printPath(m, n - 1, "R" + P));
        }
        if (m>0 && n>0) {
            x.addAll(printPath(m-1,n-1, "X" + P));
        }
        return x;
    }
    public static ArrayList<String> printPathObstacles(int m, int n, boolean[][] maze, String P) {
        if (!maze[m][n]) return new ArrayList<>();
        if (m ==maze.length-1 && n==maze[0].length-1) {
            ArrayList<String> al = new ArrayList<>();
            al.add(P);
            return al;
        }
        ArrayList<String> x = new ArrayList<>();
        if (m<maze.length-1) {
            x.addAll(printPathObstacles(m + 1, n, maze, "D" + P));
        }
        if (n< maze[0].length-1) {
            x.addAll(printPathObstacles(m, n + 1, maze,  "R" + P));
        }
        return x;
    }
}
