package StringsAndArrays;

/**
 * String compression
 */
public class StringCompression {

    /**
     * Compress String
     * @param str Input String
     * @return returns compressed string
     */
    public static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            counter++;
            if (str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(counter);
                counter = 0;
            }
        }
        sb.append(str.charAt(str.length()-1));
        sb.append(++counter);
        return sb.toString();
    }

    /**
     * Returns the amount of character changes
     * @param str Input string
     * @return Returns the number of character changes in the Input String
     */
    public static int charChanges(String str) {
        int counter = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Returns the better string
     * @param str Input String
     * @return Returns the Input string if its shorter than the would be compressed string, otherwise compresses and returns new string
     */
    public static String run(String str) {
        if (charChanges(str) * 2 > str.length()) return str;
        else return compress(str);
    }

    public static void main(String[] args) {
        String a = "aabbaabbaabb";
        System.out.println(run(a));

    }











}
