/*
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
 */
package arraysandstrings;

import java.util.Arrays;

/**
 * @author Nazareh created on 29-JAN-2018
 */
public class ZeroMatrix {

    public static int[][] zeroRow(int[][] matrix, boolean[] rows) {

        for (int row = 0; row < rows.length; row++) {
            if (rows[row]) {
                for (int col = 0; col < matrix[row].length; col++) {

                    matrix[row][col] = 0;
                }
            }
        }
        return matrix;
    }
    public static int[][] zeroCol(int[][] matrix, boolean[] cols) {

        for (int col = 0; col < cols.length; col++) {
            if (cols[col]) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        return matrix;
    }
    public static int[][] zeroRowAndCol(int[][] matrix) {

        //A arrays containing the rows that should be 0ed;
        boolean[] rows = new boolean[matrix.length];
        //A arrays containing the cols that should be 0ed;
        boolean[] cols = new boolean[matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {

                    rows[r] = true;
                    cols[c] = true;
                }
            }
        }
        zeroRow(matrix, rows);
        zeroCol(matrix, cols);
        return matrix;
    }
    public static void print2DArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void main(String[] args) {
        int rows = 5;
        int cols = 7;
        int[][] matrix = RotateMatrix.createMatrix(rows, cols);
        matrix = RotateMatrix.initMatrix(matrix);
        matrix[0][1] = 0;
        matrix[3][1] = 0;
        matrix = zeroRowAndCol(matrix);

        print2DArray(matrix);
    }
}
