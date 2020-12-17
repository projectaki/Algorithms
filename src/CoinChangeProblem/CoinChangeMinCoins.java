package CoinChangeProblem;

import java.util.Arrays;

/**
 * @author akos madarasz
 * @date 17/12/2020 - 11:49
 * @project Algorithms
 */
public class CoinChangeMinCoins {

    /**
     * Creates a dynamic table to calculate the minimum amount of coins needed to get the given amount
     * @param coins Array of given coins
     * @param target Target value
     * @return Returns the minimum value
     */
    public static int minCoinsDynamic(int[] coins, int target) {
        int[][] table = new int[coins.length][target + 1];
        Arrays.sort(coins);

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                // current coin
                int currentCoinValue = coins[i];
                // If we are in the first row special case
                if (i == 0) {
                    if (j%currentCoinValue == 0) table[i][j] = j/currentCoinValue;
                }
                // If we are not in the first row
                else{
                    // we can only make 0 if we take 0 coins so 0 is min
                    if (j == 0) table[i][j] = 0;
                    else {
                        int currentMin;
                        int remainIndex = j % currentCoinValue;
                        currentMin = j/currentCoinValue;
                        if (currentCoinValue > j) table[i][j] = table[i - 1][j];
                        else {
                            currentMin = Math.min(table[i - 1][j], table[i][remainIndex] + currentMin);
                            table[i][j] = currentMin;
                        }
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
        int[] coins = {1, 5, 6, 9};
        int res = minCoinsDynamic(coins, 10);
        System.out.println(res);


    }
}
