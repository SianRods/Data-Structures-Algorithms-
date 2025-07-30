import java.util.HashMap;

public class MaximumLengthSubstringWithTwoOccurences {
    public static void main(String[] args) {
        // String s = "bcbbbcba";
        String s = "aaaa";
        System.out.println(maximumLengthSubstring(s));
    }

    // As s only consists of lower english characters we could also have used
    // character
    // arrays to track the frequency

    public static int maximumLengthSubstring(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int maxLen = 0;
        int maxFreq = 2;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (j < n) {
            char c = s.charAt(j);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(c));

            // Removing Elements till all the frequencies are less than
            while (i <= j && maxFreq > 2) {
                char ch = s.charAt(i);
                if (maxFreq == hm.get(ch)) {
                    maxFreq--;
                }
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 0) {
                    hm.remove(ch);
                }
                i++;
            }

            if (maxFreq <= 2) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j++;

        }

        return maxLen;
    }
}
