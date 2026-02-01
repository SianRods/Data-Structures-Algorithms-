
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        // String s = "a";
        // String t = "aa";
        System.out.println(solution(s, t));
    }

    public static String solution(String s, String t) {
        // Note that here we can't use hashmaps and need to use arrays
        // as the hashmap causes overflow conditions
        if (s.length() < t.length())
            return "";

        int thm[] = new int[128];
        int shm[] = new int[128];

        int satisfied = 0;
        int m = s.length();
        int n = t.length();
        int size = 0;

        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            thm[c]++;
        }

        size = 0;
        for (int i = 0; i < 128; i++) {
            if (thm[i] > 0)
                size++;
        }

        int i = 0;
        int j = 0;

        // Set to a Maximum Value
        int count = Integer.MAX_VALUE;

        // poninters for storing the subtring indexes
        int minStart = 0;

        while (j < m) {
            char c = s.charAt(j);
            shm[c]++;

            // check for the satisfaction of character frequency
            if (thm[c] > 0 && thm[c] == shm[c]) {
                satisfied++;
            }

            while (satisfied == size && i <= j) {
                char x = s.charAt(i);

                // Recording the window first and then breaking the character
                if (j - i + 1 < count) {
                    count = j - i + 1;
                    minStart = i;
                }

                shm[x]--;
                // now check if the character that is being removed is part of the mandotary
                // characters
                // from the string t
                if (thm[c] > 0 && thm[x] > shm[x]) {
                    satisfied--;
                }

                i++;

            }

            j++;
        }

        if (count == Integer.MAX_VALUE)
            return "";

        return s.substring(minStart, minStart + count);

    }

}
