package StringsAndArrays;

public class PermutationOfPalindrome {

    private int[] hashTable;

    public PermutationOfPalindrome(String str) {
        hashTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        hash(str);
    }

    public void hash(String str) {
        for (int i = 0; i < str.length(); i++) {
            hashTable[Character.getNumericValue(str.charAt(i))]++;
        }
    }

    public boolean isPermutation() {
        int numberOfOddCount = 0;
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] % 2 == 1) numberOfOddCount++;
        }
        return numberOfOddCount <= 1;
    }

    public static boolean isPermutationPalindrome(String str) {

        int bitarray = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = Character.getNumericValue(str.charAt(i) - 10);
            bitarray ^= (1 << val);
        }
        return (bitarray & (bitarray - 1)) == 0;
    }


    public static void main(String[] args) {
        String a = "ab";
        PermutationOfPalindrome p = new PermutationOfPalindrome(a);
        System.out.println(p.isPermutation());
        System.out.println(isPermutationPalindrome(a));

    }




}
