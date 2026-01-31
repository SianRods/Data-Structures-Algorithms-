import java.util.Collections;
import java.util.HashMap;

public class LRC_Optimal {
    // Note that the below solution can be made more optimized by using an array to
    // store the frequency
    // as we know that only uppercase english letters will be present in the input

    public static void main(String[] args) {
        String str = "AABCBABBA";
        int i = 0;
        int j = 0;
        int n = str.length();
        int maxi = 0;
        int k = 2;
        int arr[] = new int[26]; // default values is '0'
        // Mainitaining a max frequency to keep the track of maxFreq in the window
        int maxFreq = 0;

        while (i < n && j < n) {
            char c = str.charAt(j);
            arr[c - 'A']++;
            maxFreq = Math.max(maxFreq, arr[c - 'A']);

            // if the window violates the condition
            while ((j - i + 1) > maxFreq + k) {
                char x = str.charAt(i);
                arr[x - 'A']--;
                i++;
            }

            maxi = Math.max(maxi, j - i + 1);
            j++;
        }
        // return maxi;

    }
}
