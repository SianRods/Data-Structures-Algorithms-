import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        // String s = "egg";
        // String t = "aad";
        String s = "bbbaaaba";
        String t = "aaabbbba";
        System.out.println(solution1(s, t));
    }

    /**
     * 
     * Isometric Strings --> Using HashMaps --> Least Optimized
     * 
     * @param s
     * @param t
     * @return
     */
    public static boolean solution1(String s, String t) {
        Map<Character, Character> shm = new HashMap<>();
        Map<Character, Character> thm = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (shm.containsKey(sc)) {
                if (shm.get(sc) != tc) {
                    return false;
                }
            }
            if (thm.containsKey(tc)) {
                if (thm.get(tc) != sc) {
                    return false;
                }
            }
            shm.put(sc, tc);
            thm.put(tc, sc);

        }

        return true;

    }

    // Solution with arrays instead of hashmaps
    // Here we already know that the characters of the string contains only the
    // ASCII
    // values --> 256 hence using the frequency array
    public static boolean solution2(String s, String t) {

        int st[] = new int[256];
        int ts[] = new int[256];

        // fill with -1 to denote that they have not been mapped to any character
        // initially
        Arrays.fill(ts, -1);
        Arrays.fill(st, -1);

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            // check if both the characters are not added
            if (st[sc] == -1 && ts[tc] == -1) {
                // Add them to the map
                st[sc] = tc;
                ts[tc] = sc;
            } else if (st[sc] != tc || ts[tc] != sc) {
                // violation of the mapping condition
                // characters cannot be replaced
                return false;
            }

        }

        return true;

    }

}
