import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        // String str = "aababbcaacc";
        String str = "abcddefg";
        // int k = 2;
        int k = 3;
        System.out.println(solution(str, k));

    }

// note that this solution can be made more faster by using a frequency map

    public static int solution(String str, int k) {
        int n = str.length();

        HashMap<Character, Integer> hm = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < n) {
            char c = str.charAt(j);
            hm.put(c, hm.getOrDefault(c, 0) + 1);

            // violation of the atmost k distinct characters
            while (hm.size() > k && i <= j) {

                char x = str.charAt(i);
                hm.put(x, hm.get(x) - 1);
                if (hm.get(x) == 0) {
                    hm.remove(x);
                }
                i++;
            }

            // keep counting whenever the maximum size is less than or equal to k
            if (hm.size() <= k) {
                count = Math.max(count, j - i + 1);
            }

            // keep the record of the longest subtring found till now
            j++;
        }

        return count;
    }
}
