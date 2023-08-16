package backtracking;

public class sudokuSolver {

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
            for (char[] arr : board) {
                    for (char c : arr) {
                            System.out.print(c + " ");
                    }
                    System.out.println();
            }
    }
        public static void solveSudoku(char[][] board) {
            helper(board);

        }
        public static boolean helper(char[][] board) {

            for (int i = 0; i<9; i++) {
                for (int j = 0; j<9; j++) {
                    if (board[i][j] == '.') {
                        for (char num = '1'; num<='9'; num++){
                            if (isSafe(board, i, j, num)){
                                board[i][j] = num;
                                if (helper (board)) return true;
                                board[i][j] = '.';
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        public static boolean isSafe(char[][] board, int row, int col, char num) {
            for (int i = 0; i<9; i++) {
                if (board[row][i] == num) return false;
            }

            for (int i = 0; i<9; i++) {
                if (board[i][col] == num) return false;
            }

            row = row - row%3;
            col = col - col%3;
            for (int i = row; i<row+3; i++) {
                for (int j= col; j<col+3; j++) {
                    if (board[i][j] == num) return false;
                }
            }

            return true;

        }
}


