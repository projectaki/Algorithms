package StringsAndArrays;

/**
 * Class for rotating an NxN matrix by 90 degrees
 */
public class RotateMatrix {

    /**
     * Rotate NxN matrix
     * @param matrix Input 2D NxN matrix
     * @return returns the 90 degree rotated matrix
     */
    public static int[][] rotateMatrix(int[][] matrix) {
        if (matrix.length != matrix[0].length) throw new IllegalArgumentException();
        int N = matrix.length;

        int counter = 0;
        // We swap values in layers, starting from outward going inward
        // Each layer has 2 rows and 2 columns, therefore there are N/2 Layers

        for (int i = 0; i < matrix.length / 2; i++) {

            // We loop until N-1 because the last element of the row has already been swapped, the (2*counter) is subtracted because at each layer the size decreases
            // by 2, one at the start and one at the end.
            for (int j = 0; j < (matrix.length - (2 * counter) - 1); j++) {

                // the "+ counter" is the position of j shifting by 1 at each new layer
                // Save top
                int temp = matrix[i][j + counter];
                // Left => Top
                matrix[i][j + counter] = matrix[N - j - 1 + counter][i];
                // Bottom => Left
                matrix[N - j - 1 + counter][i] = matrix[N - 1 + counter][N - j - 1 + counter];
                // Right => Bottom
                matrix[N - 1 + counter][N - j - 1 + counter] = matrix[j + counter][N - 1 + counter];
                // Top => Right
                matrix[j + counter][N - 1 + counter] = temp;
            }
            // j shifter value
            counter++;
            // N decreases by 2 at each layer
            N -= 2;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[7][7];
        int c = 100;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                matrix[i][j] = c++;
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println( "-------------------------");

        rotateMatrix(matrix);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }




}
