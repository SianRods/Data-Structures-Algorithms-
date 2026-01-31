import java.util.Collections;
import java.util.HashMap;

public class LongestRepeatingCharacter {
    // below solution results in an O (n**2) --> solution --> 211 ms runtime
    //

    public static void main(String[] args) {

        String str = "AABCBABBA";
        int i = 0;
        int j = 0;
        int n = str.length();
        int maxi = 0;
        int k = 2;
        HashMap<Character, Integer> hm = new HashMap<>();

        while (i < n && j < n) {
            char c = str.charAt(j);
            hm.put(c, hm.getOrDefault(c, 0) + 1);

            // if the window violates the condition
            while (hm.values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum() > Collections.max(hm.values()) + k) {
                char x = str.charAt(i);

                hm.put(x, hm.getOrDefault(x, 0) - 1);
                i++;
            }

            maxi = Math.max(maxi, j - i + 1);
            j++;
        }
        // return maxi;

    }
}
