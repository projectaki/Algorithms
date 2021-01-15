package RecursionAndDP;

/**
 * @author akos madarasz
 * @date 15/01/2021 - 12:52
 * @project Algorithms
 */
public class TowersOfHanoi {

    public static void hanoi(int n, int og, int buff, int dest) {

        if (n == 1){
            System.out.println(og  + " ---> " + dest);
            return;
        }

        hanoi(n - 1, og, dest, buff);
        System.out.println(og  + " ---> " + dest);
        hanoi(n - 1, buff, og, dest);
    }

    public static void main(String[] args) {

        hanoi(3, 1, 2, 3);


    }
}
