import java.util.HashMap;

public class LongestSubString {
    public static void main(String[] args) {
        String str = "abcabcbb";
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = str.length();
        int i = 0;
        int j = 0;
        int max = 0; // stores the maximum lenght of the substring

        while (j < n && i < n) {
            char c = str.charAt(j);
            hm.put(c, hm.getOrDefault(c, 0) + 1);

            // now check whether the current character --> violates the
            // condition inside of the subtring

            while (hm.get(c) > 1 && i < n) {
                char x = str.charAt(i);
                hm.put(x, hm.get(x) - 1);
                i++;

            }

            max = Math.max(max, j - i + 1);
            j++;

        }

    }

}
