import java.util.HashSet;
import java.util.Hashtable;

public class SubstringWithAllThreeCharacters {
    public static void main(String[] args) {
        // String str = "abcabc";
        String str = "aaaacb";
        System.out.println(substringWithAllThree(str));
    }

    public static int substringWithAllThree(String str) {
        // Hashtable<Character, Integer> hm = new Hashtable<>();
        // more optmized way to store the frequency of the elements using array
        int arr[] = new int[3];

        int i = 0;
        int j = 0;
        int n = str.length();
        int count = 0;
        // edge case --> aaaabc

        while (j < n) {
            char c = str.charAt(j);
            arr[c - 'a']++;

            // if the condition is satisfied then count the substrings
            while (arr[0] >= 1 && arr[1] >= 1 && arr[2] >= 1 && i <= j) {
                char x = str.charAt(i);
                count += n - j;
                arr[x - 'a']--;
                i++;
            }

            j++;
        }

        return count;

    }
}
