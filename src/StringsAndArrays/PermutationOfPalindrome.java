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



    public static void main(String[] args) {
        String a = "ababcfdfdc";
        PermutationOfPalindrome p = new PermutationOfPalindrome(a);
        System.out.println(p.isPermutation());

    }




}
