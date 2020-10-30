package StringsAndArrays;

/**
 * Given 2 string decide if it is 1 edit away
 */
public class OneAway {

    /**
     * When the strings are the same lengths
     * @param first First string
     * @param second Second String
     * @return True if 1 edit away
     */
    private static boolean replace(String first, String second) {
        boolean found = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (found) return false;
                found = true;
            }
        }
        return true;
    }

    /**
     * If string difference is 1
     * @param shorter 1 shorter than longer string
     * @param longer 1 longer than shorter string
     * @return True if 1 edit away
     */
    private static boolean AddOrDelete(String shorter, String longer) {

        boolean found = false;
        int i = 0;
        int j = 0;
        while(i != shorter.length()) {
            if (shorter.charAt(i) != longer.charAt(j)) {
                if (found) return false;
                j++;
                found = true;
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }

    /**
     * Checks if 2 strings are 1 edit away
     * @param s1 String 1
     * @param s2 String 2
     * @return Returns if 2 string are 1 edit away
     */
    public static boolean isOneEditAway(String s1, String s2) {
        String shorter = s1.length() < s2.length() ? s1 : s2;
        String longer = shorter.equals(s1) ? s2 : s1;

        if (longer.length() - shorter.length() == 1) {
            return AddOrDelete(shorter,longer);
        }
        else if (longer.length() - shorter.length() == 0) {
            return replace(shorter,longer);
        }
        else return false;
    }

    public static void main(String[] args) {
        String a = "pale";

        String b = "pales";

        System.out.println(isOneEditAway(a,b));
    }




}
