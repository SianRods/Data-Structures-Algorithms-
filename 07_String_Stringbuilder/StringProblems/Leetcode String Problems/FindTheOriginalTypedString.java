import java.util.Collection;
import java.util.Hashtable;

public class FindTheOriginalTypedString {
    public static void main(String[] args) {

    }

    public static int possibleStringCount(String word) {

        // Here we only need to look at the occurence of the consecutive characters
        // if the same characters are spread across then we can't account those

        // Here we can just track the sequence of the characters in a order using a
        // normal variable
        int count = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            }
        }

        return count + 1;
    }
}
