package RecursionAndDP;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author akos madarasz
 * @date 15/01/2021 - 13:19
 * @project Algorithms
 */
public class PermStringUnique {

    public static ArrayList<String> printPerm(String str) {

        if (str.length() == 1) {
            ArrayList<String> newPerms = new ArrayList<>();
            newPerms.add(str);
            return newPerms;
        }

        char prefix = str.charAt(0);
        ArrayList<String> perms = printPerm(str.substring(1));

        ArrayList<String> newPerms = new ArrayList<>();
        for (String s : perms) {

            for (int i = 0; i < s.length() + 1; i++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, prefix);
                newPerms.add(sb.toString());
            }

        }
        return newPerms;
    }


    public static void main(String[] args) {
        System.out.println(printPerm("abcd"));
        //printPerm("abc");
    }
}
