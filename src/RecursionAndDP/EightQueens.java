package RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author akos madarasz
 * @date 20/01/2021 - 12:37
 * @project Algorithms
 */
public class EightQueens {

    public static void queens(int boardParam) {
        int[] placed = new int[boardParam];
        queens(boardParam, placed, 0);

    }

    public static void queens(int n, int[] placed, int row) {
        if (row == n) {System.out.println(Arrays.toString(placed)); return;}
        for(int c = 0; c < n; c++) {
            if (canBePlaced(c, row, placed)) {
                placed[row] = c;
                queens(n, placed, row + 1);
            }

        }
    }

    public static boolean canBePlaced(int col, int row, int[] placed) {
        for (int i = 0; i < row; i++) {
            if (placed[i] == col) return false;
            if (Math.abs(i - row) == Math.abs(placed[i] - col)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        queens(8);
    }

}
