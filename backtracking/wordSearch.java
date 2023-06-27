package backtracking;

public class wordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }

        public static boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    char ch = board[i][j];
                    if (ch == word.charAt(0) && helper(board, word, i, j,"")){
                        return true;
                    }
                }
            }
            return false;
        }

        public static boolean helper(char[][] board, String target, int m, int n, String P) {
            if (board[m][n] == '0') return false;
            if (target.length() == 1) return true;
            char temp = board[m][n];
            board[m][n]= '0';
            char s = target.charAt(0);
            target = target.substring(1);
            boolean x = false;
            char f = target.charAt(0);

            if (m < board.length - 1 && board[m+1][n] == f) {
                x = x || helper(board, target, m + 1, n,P );
            }
            if (n < board[0].length - 1 && board[m][n+1] == f) {
                x = x || helper(board, target,m, n + 1, P);
            }
            if (m > 0 && board[m-1][n] == f) {
                x = x || helper( board,target,m - 1, n, P);
            }
            if (n > 0 && board[m][n-1] == f) {
                x = x || helper(board, target,m, n - 1, P);
            }
            board[m][n] = temp;
            target = s + target;
            return x;
        }
}
