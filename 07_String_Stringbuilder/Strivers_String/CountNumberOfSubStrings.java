
import java.util.HashMap;

public class CountNumberOfSubStrings {
    public static void main(String[] args) {
        // String s = "pqpqs";
        String s = "abcbaa";
        // int k = 2;
        int k = 3;
        System.out.println(solution1(s, k));
        System.out.println(solution1(s, k - 1));
        System.out.println(solution1(s, k) - solution1(s, k - 1));
    }

    // AtMost(k)-AtMost(k-1) == Exactly(K);

    public static int solution1(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < n) {
            char c = s.charAt(j);

            // first insert the character into the hashmap
            hm.put(c, hm.getOrDefault(c, 0) + 1);

            while (i <= j && hm.size() > k) {
                char t = s.charAt(i);
                hm.put(t, hm.get(t) - 1);
                if (hm.get(t) == 0) {
                    hm.remove(t);
                }
                i++;

            }

            // Record the count of the strings
            count += (j - i + 1);

            j++;

        }

        return count;

    }

}
