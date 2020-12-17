package CoinChangeProblem;

import java.util.Arrays;

/**
 * @author akos madarasz
 * @date 17/12/2020 - 12:39
 * @project Algorithms
 */
public class CoinChangeHowMany {

    /**
     * Method for counting how many ways can we get the target value with given coins
     * @param coins Given array of coins
     * @param target Target value
     * @return Returns the number of ways
     */
    public static int howMany(int[] coins, int target) {
        int[][] table = new int[coins.length][target + 1];
        Arrays.sort(coins);

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                // if first row special case
                int currentCoinValue = coins[i];
                if (i == 0) {
                    if (j % currentCoinValue == 0) table[i][j] = 1;
                }
                // if not first row
                else {
                    if (currentCoinValue > j) table[i][j] = table[i - 1][j];
                    else {
                        int remainIndex = j - currentCoinValue;
                        table[i][j] = table[i - 1][j] + table[i][remainIndex];
                    }
                }
            }
        }
//        for (int i = 0; i < table.length; i++) {
//            for (int j = 0; j < table[0].length; j++) {
//                System.out.print(table[i][j] + "|");
//            }
//            System.out.println();
//        }
        return table[table.length - 1][table[0].length - 1];
    }

    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 10};
        System.out.println(howMany(coins, 15));
    }
}
