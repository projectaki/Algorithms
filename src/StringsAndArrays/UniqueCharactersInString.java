package StringsAndArrays;

public class UniqueCharactersInString {

    public UniqueCharactersInString()
    {

    }

    public boolean isUniqueChars(String str, int alphabetLength) {
        if (str.length() > alphabetLength) return false;

        boolean[] char_set = new boolean[alphabetLength];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if ( char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    public boolean isUniqueCharsBit(String str) {
        // Bit array with every element 0
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            // get the position of i th character
            int charPosition = str.charAt(i) - 'a';
            // if the values found so far has a 1 at i th character position then we have a duplicate
            // we set ith to 1, and if there is already a 1 then 1 & 1 will return 1, which is > 0
            if ( (checker & (1 << charPosition)) > 0 ) return false;
            // checker gets merged with the current found value, forming the values found so far
            // the or operation takes the 1s for either strings so a merge happens
            checker |= (1 << charPosition);
        }
        return true;
    }

    public static void main(String[] args) {

        UniqueCharactersInString u = new UniqueCharactersInString();

        String a = "abcde";
        String b = "aabcde";


        System.out.println(u.isUniqueChars(a,128));
        System.out.println(u.isUniqueChars(b,128));
        System.out.println(u.isUniqueCharsBit(a));
        System.out.println(u.isUniqueCharsBit(b));


    }








}
