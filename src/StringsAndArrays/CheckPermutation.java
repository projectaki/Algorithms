package StringsAndArrays;

public class CheckPermutation {

    /**
     * Assuming only small letters of the alphabet
     * @param a String a
     * @param b String b
     * @return returns True if String a is permutation of String b
     */
    public static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] hashTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (int i = 0; i < a.length(); i++) {
            hashTable[Character.getNumericValue(a.charAt(i))]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int curr = hashTable[Character.getNumericValue(b.charAt(i))];
            curr--;
            if (curr < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "dcba";
        String b = "abcd";
        System.out.println(isPermutation(a,b));
    }
}
