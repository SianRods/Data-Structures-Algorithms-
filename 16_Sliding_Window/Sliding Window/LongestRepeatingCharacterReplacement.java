import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

    }

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int maxLen = 0;
        // Using a Hashtable for our fixed character inputs
        char arr[] = new char[26];

        while (j < n) {
            char c = s.charAt(j);
            arr[c - 'A']++;
            maxFreq = Math.max(maxFreq, arr[c - 'A']);

            // Checking the String when the diff b/w length of string and the maxFreq >
            // k(atmost allowed changes)

            while (k < (j - i + 1) - maxFreq) {
                maxFreq = 0;
                char ch = s.charAt(i);
                arr[ch - 'A']--;

                for (int r = 0; r <= 25; r++) {
                    maxFreq = Math.max(maxFreq, arr[r]);
                }

                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }

}
