import java.util.Hashtable;

public class LongestRepeatingCharacterReplacement {

    // Here ther is a clear indication of sliding window pattern as well as
    // we can clearly see that sliding window can be further optimized in a
    // similar way to that of previously sovled optimized questions on sliding
    // window

    // Constraint => We have to only choose a single character to be replaced atmost
    // k times
    // we can't choose k different characters to be replaced

    public static void main(String[] args) {

    }

    public static int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        Hashtable<Character, Integer> hm = new Hashtable<>();
        int maxLength = 0;
        Character ch;
        while (j < n) {
            ch = s.charAt(j);
            if (s.charAt(i) == ch) {
                j++;
                continue;
            }

            if (s.charAt(i) != ch) {
                // If the characters are not equal then we just try to check the hashtable
                if(!hm.isEmpty()){
                    Object onlyKey = hm.keySet().toArray()[0];
                    
                }
            }
        }

    }

}
