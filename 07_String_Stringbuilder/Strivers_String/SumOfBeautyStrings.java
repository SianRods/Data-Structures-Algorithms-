
public class SumOfBeautyStrings {
    public static void main(String[] args) {
        String s = "aabcbaa";
        System.out.println(solution2(s));
    }

    // Unoptimized Solution
    // 1. Two characters are required
    // 2. maintaining for each subtring largest freq element and min freq element
    // 3. The bare minimum requirement which we have to follow here is iterating and
    // checking over
    // each and every possible substrings
    public static int solution1(String s) {
        // Only lower case characters
        int n = s.length();
        // here we are maintaining frequency for each and every substring
        int count = 0;
        for (int i = 0; i < n; i++) {
            int freq[] = new int[26]; // all initialized to zero
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                int max = getMax(freq);
                // int min = getMin(freq);
                // count += (max - min);
            }
        }

        return count;
    }

    public static int getMax(int freq[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
            }

        }
        return max;

    }

    public static int getMin(int freqCount[], int max) {
        int min = Integer.MAX_VALUE;
        for (int f = 1; f <= max; f++) {
            if (freqCount[f] > 0) {
                min = f;
                break;
            }
        }
        return min;

    }

    // Optimized Solution
    public static int solution2(String s) {
        // Only lower case characters
        int n = s.length();
        // here we are maintaining frequency for each and every substring
        int count = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            int freq[] = new int[26];
            int freqCount[] = new int[n + 1];// count of elements with the frequency of [0,1,2...n]
            // the above array is used to qucikly loop up on the minimum part of the array
            for (int j = i; j < n; j++) {
                int ch = s.charAt(j) - 'a';

                int oldFreq = freq[ch];
                int newFreq = oldFreq + 1; // latest updated frequency for a given character
                freq[ch]++;

                if (oldFreq > 0) {
                    freqCount[oldFreq]--;
                }
                freqCount[newFreq]++;

                max = Math.max(max, newFreq);
                int min = getMin(freqCount, max);
                count += (max - min);
            }
        }

        return count;
    }

}