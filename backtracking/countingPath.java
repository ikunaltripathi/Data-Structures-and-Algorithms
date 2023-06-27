package backtracking;

public class countingPath {
    public static void main(String[] args) {
        System.out.println(countingPaths(3,3));
    }

    private static int countingPaths(int m, int n) {
        if (m == 1 || n==1) return 1;
        int x = countingPaths(m-1,n);
        int y = countingPaths(m,n-1);
        return x+y;
    }

}
