
// package 13_ Algorithms.Two Pointer&Sliding Window;
import java.util.HashMap;

public class LongestSubString {
    // Two methods/apporaches can be used one can invlove use of internal string
    // fucntions other can
    // be use of hashmaps which are more efficient

    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int i = 0;
        int j = 0;
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        while (j < n) {
            Character ch = s.charAt(j);

            if (hm.containsKey(ch)) {
                // If the the substring contains the character but it is <i then we don't have to worry about it 
                // if >=i withing bounds then we update i 
                if (hm.get(ch) >= i) {
                    i = hm.get(ch) + 1;
                }
            }

            // else if the character at j is still not present then we directly add it and update the maxLength variable 
            hm.put(ch, j);
            j++;
            maxLength = Math.max(maxLength, j - i + 1);
        }


        return maxLength;
    }

}
