import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {
    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        // here the brute force solution involves storing the indices of the
        // with their indices and then again iterating through then and
        // replacing each one
        // Sliding window two pointers one at start and one at end when both are at
        // vowels we swap them
        char sarr[] = s.toCharArray();
        int n = s.length();
        int i = 0;
        int j = n - 1;
        Character ch;

        Set<Character> vowels = new HashSet<>(Arrays.asList(
                'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        // Note that this solution can be made more optimized by using hashmap to loop
        // up for the
        // presence of a character in a set
        boolean indexI;
        boolean indexJ;
        while (i <= j) {
            indexI = vowels.contains(sarr[i]);
            indexJ = vowels.contains(sarr[j]);

            if (indexI && indexJ) {
                // Both the pointers are pointing towards vowels hence can be switched
                ch = sarr[i];
                sarr[i] = sarr[j];
                sarr[j] = ch;
                i++;
                j--;
                continue;
            }

            if (!indexI && indexJ) {
                i++;
                continue;
            }

            if (indexI && !indexJ) {
                j--;
                continue;
            } else {
                i++;
                j--;
                continue;
            }

        }

        return new String(sarr);
    }
}
