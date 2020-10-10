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

    public static void main(String[] args) {

        UniqueCharactersInString u = new UniqueCharactersInString();

        String a = "abcde";
        String b = "aabcde";


        System.out.println(u.isUniqueChars(a,128));
        System.out.println(u.isUniqueChars(b,128));


    }








}
