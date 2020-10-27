package StringsAndArrays;

import java.util.Random;

/**
 * Class for setting row and col of matrix to 0 of currently 0 cell
 */
public class ZeroMatrix {

    public static void setZeros(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
    }

    public static void nullifyCol(int j, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = -1;
        }
    }

    public static void nullifyRow(int i, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = -1;
        }
    }

    public static void run(int[][] matrix) {
        setZeros(matrix);
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) nullifyCol(j,matrix);
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) nullifyRow(i,matrix);
        }

        if (matrix[0][0] == 0) {
            nullifyCol(0,matrix);
            nullifyRow(0,matrix);
        }
    }

    public static void main(String[] args) {

        int[][] matrix = new int[5][7];
        int c = 10;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                matrix[i][j] = c++;
            }
        }
        matrix[3][5] = 0;
        matrix[0][1] = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println( "-------------------------");

        run(matrix);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println( "-------------------------");
    }
}
