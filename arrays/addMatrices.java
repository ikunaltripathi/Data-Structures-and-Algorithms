package arrays;

import java.util.Arrays;

public class addMatrices {
    public static void main(String[] args) {
        int[][] mat1= {
                {1,2,3,4},
                {5,6,7,8}
        };
        int[][] mat2 = {
                {2,3,4},
                {9,7,8},
                {5,2,7},
                {1,5,9}
        };
//        int[][] sum = new int[2][2];
//        for (int i = 0; i<2; i++) {
//            for (int j = 0; j < 2; j++) {
//                sum[i][j] = mat1[i][j] + mat2[i][j];
//            }
//        for (int[] row : sum)
//                System.out.println(Arrays.toString(row));

        // Multiplication
        int[][] mul = new int[2][3];
        for (int i = 0; i<2; i++)// rows of a
        {
            for (int j = 0; j<3; j++) // colums of b
            {
                for (int k =0; k<4; k++) // columns of a
                {
                    mul[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        for (int[] row : mul)
              System.out.println(Arrays.toString(row));
        }
    }
