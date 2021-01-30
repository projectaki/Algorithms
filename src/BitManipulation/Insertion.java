package BitManipulation;

/**
 * @author akos madarasz
 * @date 29/01/2021 - 17:34
 * @project Algorithms
 */
public class Insertion {

    public static void insertion(int N, int M, int gi, int gj) {
        int mIndex = 0;
        for (int i = gi; i <= gj;i++ ) {
            boolean toInsert = getBit(M, mIndex++);
            if(toInsert) N = setBit(N, i);
            else N = clearBit(N, i);
        }
        printBinaryRepresentation(N);
    }

    public static void printBinaryRepresentation(int number) {
        for (int i = 31; i >= 0 ; i--) {
            if((number & (1 << i)) != 0) System.out.print("1");
            else System.out.print("0");
        }
    }

    public static boolean getBit(int number, int i) {
        return (number & (1 << i)) != 0;
    }

    public static int setBit(int number, int i) {
        return (number | (1 << i));
    }

    public static int clearBit(int number, int i) {
        return (number & ~(1 << i));
    }

    public static void main(String[] args) {
        int N = 1024;
        int M = 19;
        int i = 2;
        int j = 6;
        //printBinaryRepresentation(M);
        insertion(N,M,i,j);
    }
}
