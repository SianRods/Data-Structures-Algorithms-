import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class NumberOfSubstringContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "abc";

        System.out.println(bruteForceNumberOfSubstrings(s));
    }

    public static int bruteForceNumberOfSubstrings(String s) {
        // The brute force approach consists of generating all the possible subsequences
        // and
        // then checking whther it contains specific characters or not
        int i = 0;
        int j = 0;
        int count = 0;
        int n = s.length();

        // Minimum 3 characters required in the string to satisfy the given condition
        while (i < n - 2) {
            j = i;
            Set<Character> required = new HashSet<>(Arrays.asList('a', 'b', 'c'));
            // System.out.println(required);
            while (!required.isEmpty() && j < n) {
                if (required.contains(s.charAt(j))) {
                    required.remove(s.charAt(j));
                }
                j++;
                // System.out.println(required);

            }

            if (required.isEmpty()) {
                count += n - j + 1;
            }
            i++;

        }

        return count;

    }

    public static int numberOfSubstrings(String s) {
        int i = 0;
        int lastSeen[] = { -1, -1, -1 };
        int n = s.length();
        int count = 0;

        while (i < n) {
            // Updating the index where the item (a,b,c) was last seen
            lastSeen[s.charAt(i) - 'a'] = i;

            if (lastSeen[0] >= 0 && lastSeen[1] >= 0 && lastSeen[2] >= 0) {
                count += Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]) + 1;
            }

        }

        return count;

    }

    static public int minOfLastSeen(int arr[]) {
        return Math.min(Math.min(arr[0], arr[1]), arr[2]);
    }

}
