package BitManipulation;

/**
 * @author akos madarasz
 * @date 30/01/2021 - 10:55
 * @project Algorithms
 */
public class LongestSequenceWithOneFlip {

    public static int flip(int num) {
        boolean firstZeroFound = false;
        int count1 = 0;
        int count2 = 0;
        int max = 0;

        for (int i = 0; i < 32; i++) {
            // before the first zero is found we increment count1
            if(!firstZeroFound) {
                if(!getBit(num, i)) {
                    firstZeroFound = true;
                }
                else count1++;
            }
            // if we had a 0 already
            else {
                // if the bit at i == 0 meaning we have 2 zeros so we see if the sequence is bigger than max so far
                if(!getBit(num, i)) {
                    max = Math.max(max, count1 + count2 + 1);
                    count1 = count2;
                    count2 = 0;
                }
                else count2++;
            }
        }
        return max;
    }

    public static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    public static void main(String[] args) {

        System.out.print(flip(0));

    }
}
