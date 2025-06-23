import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class LongestPalindromeBuilt {
    public static void main(String[] args) {
        // String s = "abccccdd";
        String s = "bananas";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        // Here we have to built the palindrome string
        // can analyse the total number of even and odd occurences of
        // each of the character in the string

        Hashtable<Character, Integer> ht = new Hashtable<>();
        Character ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ht.containsKey(ch)) {
                ht.put(ch, ht.get(ch) + 1); // ✅ increment current character count
            } else {
                ht.put(ch, 1);
            }
        }
        // I need to sort the values in the hashmap as it will help choose max length
        // odd character to
        // obtain the longest palindrome string
        boolean hasOdd = false;
        int maxLength = 0;

        for (Integer val : ht.values()) {
            if (val % 2 == 0) {
                maxLength += val;
            } else {
                maxLength += val - 1;
                hasOdd = true;
            }
        }
        if (hasOdd)
            maxLength++;

        return maxLength;

    }

}
