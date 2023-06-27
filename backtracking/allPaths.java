package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class allPaths {
    public static void main(String[] args) {
        boolean[][] maze = {{true,true, true}, {true,true, true},{true,true,true}};
//        System.out.println(allPath(0,0, maze, ""));
        int [][] matrix = {{0,0,0}, {0,0,0}, {0,0,0}};
        printallPath(0,0, maze, "", matrix, 1);
    }

    public static ArrayList<String> allPath(int m, int n, boolean[][] maze, String P) {
        if (!maze[m][n]) return new ArrayList<>();
        if (m == maze.length - 1 && n == maze[0].length - 1) {
            ArrayList<String> al = new ArrayList<>();
            al.add(P);
            return al;
        }
        ArrayList<String> x = new ArrayList<>();
        maze[m][n] = false;
        if (m < maze.length - 1) {
            x.addAll(allPath(m + 1, n, maze, P + "D"));
        }
        if (n < maze[0].length - 1) {
            x.addAll(allPath(m, n + 1, maze, P + "R"));
        }
        if (m > 0) {
            x.addAll(allPath(m - 1, n, maze, P + "U"));
        }
        if (n > 0) {
            x.addAll(allPath(m, n - 1, maze, P + "L"));
        }
        maze[m][n] = true;
        return x;
    }
    public static void printallPath(int m, int n, boolean[][] maze, String P, int[][] matrix, int i) {
        if (!maze[m][n]) return;
        matrix[m][n] = i;
        if (m == maze.length - 1 && n == maze[0].length - 1) {
            System.out.println(P + " ");
            for (int[] j : matrix) {
                for (int x : j) {
                    System.out.print(x);
                }
                System.out.println();
            }
            System.out.println();
            matrix[m][n] = 0;
            return;
        }
        maze[m][n] = false;

        if (m < maze.length - 1) {
            printallPath(m + 1, n, maze, P + "D", matrix,i+1);
        }
        if (n < maze[0].length - 1) {
            printallPath(m, n + 1, maze, P + "R", matrix,i+1);
        }
        if (m > 0) {
            printallPath(m - 1, n, maze, P + "U", matrix,i+1);
        }
        if (n > 0) {
            printallPath(m, n - 1, maze, P + "L", matrix, i+1);
        }
        maze[m][n] = true;
        matrix[m][n] = 0;
    }
}
