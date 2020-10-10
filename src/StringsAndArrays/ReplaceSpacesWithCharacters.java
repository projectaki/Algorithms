package StringsAndArrays;

public class ReplaceSpacesWithCharacters {

    public void replaceSpaces(char[] str, int length) {
        int amountOfSpaces = amountOfChars(str,0,length,' ');
        int newIndex = length - 1 + amountOfSpaces*2;

        if(newIndex + 1 < str.length) str[newIndex + 1] = '\0';
        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ')
            {
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            }else
            {
                str[newIndex] = str[i];
                newIndex -= 1;
            }
        }
    }

    private int amountOfChars(char[] str, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (str[i] == target) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ReplaceSpacesWithCharacters r = new ReplaceSpacesWithCharacters();
        String a = "Mr john Smith    ";
        char[] b = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            b[i] = a.charAt(i);
        }
        r.replaceSpaces(b,13);
        System.out.println(b);
    }

}
