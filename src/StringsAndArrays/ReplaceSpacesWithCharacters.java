package StringsAndArrays;

import java.util.Arrays;

/**
 * Make a string into URL format, replace spaces with %20, assuming there is enough space at the end of the string
 */
public class ReplaceSpacesWithCharacters {

    /**
     * Urlify a string
     * @param url Input url
     * @param trueLength Length of the url, not the actual string length
     * @param toReplace "String to replace spaces with"
     * @return Returns the new URL
     */
    public static char[] URLify(String url, int trueLength, String toReplace) {
        int numberOfSpaces = countChar(url,0,trueLength,' ');
        int backIndex = trueLength + numberOfSpaces * (toReplace.length() - 1) - 1;
        if (backIndex >= url.length()) throw new IndexOutOfBoundsException("url not long enough");
        char[] charUrl = url.toCharArray();

        for (int i = trueLength - 1; i > 0; i--) {
            if (charUrl[i] == ' ') {
                charUrl[backIndex] = toReplace.charAt(2);
                charUrl[backIndex - 1] = toReplace.charAt(1);
                charUrl[backIndex - 2] = toReplace.charAt(0);
                backIndex -= 3;
            }
            else {
                charUrl[backIndex] = charUrl[i];
                backIndex--;
            }
        }
        return charUrl;
    }

    /**
     * Counts a given character in given interval in a given string
     * @param str Given string
     * @param start Interval start
     * @param end Interval End
     * @param character Character looking for
     * @return Returns number of found characters
     */
    public static int countChar(String str, int start, int end, char character) {
        if ((start < 0 || start > str.length()) || (end < 0 || end > str.length())) throw new IndexOutOfBoundsException();
        int count = 0;
        for (int i = start ; i < end; i++) {
            if (str.charAt(i) == character) count++;
        }
        return count;
    }


    public static void main(String[] args) {

        String url = "Marysia is super cute      ";
        int trueLength = 21;
        char[] a = URLify(url,trueLength,"%20");
        System.out.println(a);
    }



}
