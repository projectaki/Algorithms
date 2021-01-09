package RecursionAndDP;

/**
 * @author akos madarasz
 * @date 09/01/2021 - 13:39
 * @project Algorithms
 */
public class TripleStep {

    public static int possibleWays(int[] stepNumbers, int n) {
        int[] subSteps = new int[n + 1];
        return possibleWays(n, subSteps, stepNumbers);
    }
    public static int possibleWays(int remainingSteps, int[] subSteps, int[] stepNumbers) {
        if (remainingSteps < 0) return 0;
        else if (remainingSteps == 0) {
            subSteps[0] = 1;
            return 1;
        }
        if (subSteps[remainingSteps] > 0) return subSteps[remainingSteps];
        int amount = 0;

        for (int step : stepNumbers) {
            amount += possibleWays(remainingSteps - step, subSteps, stepNumbers);
        }
        subSteps[remainingSteps] = amount;
        return amount;
    }




    public static void main(String[] args) {

        int[] stepNumbers = {1,2,3};
        System.out.println(possibleWays(stepNumbers, 5));






    }
}
