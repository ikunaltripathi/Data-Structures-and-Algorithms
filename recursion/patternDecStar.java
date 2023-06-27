package recursion;

public class patternDecStar {
    public static void main(String[] args) {
        patternRec(4, 0);
//        patternRec2(4,0);
    }

    private static void patternRec(int n, int i) {
        if (n==0) return;
        if (i < n) {
            System.out.print("* ");
            patternRec(n, i + 1);

        }
        else {
            System.out.println();
            patternRec(n-1,0);

        }
    }

    private static void patternRec2(int n, int i) {
        if (n==0) return;
        if (i == n) {
            patternRec2(n-1,0);
            System.out.println();
        }
        else {
            patternRec2(n, i + 1);
            System.out.print("* ");
        }
    }
}
