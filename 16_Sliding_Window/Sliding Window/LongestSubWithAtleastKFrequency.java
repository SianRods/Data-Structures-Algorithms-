import java.util.HashMap;
import java.util.Hashtable;

public class LongestSubWithAtleastKFrequency {
    public static void main(String args[]) {
        // String str="aaabb"; k=3
        String str = "ababbc";
        int k = 2;
        System.out.println(longestSubstring(str, k));
    }

    public static int longestSubstring(String s, int k) {
        // First we will take a note of the frequency of characters present in the
        // substring
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        char pivot = '*';
        for (char c : hm.keySet()) {
            int freq = hm.get(c);

            if (freq < k) {
                pivot = c;
                break;
            }

        }

        if (pivot == '*') {
            // Here it is important to return the length of the strings instead of just
            // returning the
            // sum of frequencies of the characters
            return n;
        } else {
            int index = partitionString(s, pivot);
            int left = longestSubstring(s.substring(0, index), k);
            int right = longestSubstring(s.substring(index + 1, n), k);

            return Math.max(left, right);

        }

    }

    public static int partitionString(String s, char c) {
        int k = 0;
        int n = s.length();
        while (k < n) {
            char m = s.charAt(k);
            if (m == c) {
                break;
            }
            k++;
        }

        return k;

    }

}