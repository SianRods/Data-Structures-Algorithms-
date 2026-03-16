import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        // String s = "egg";
        // String t = "aad";
        String s = "bbbaaaba";
        String t = "aaabbbba";
        System.out.println(solution(s, t));
    }

    /**
     * 
     * Isometric Strings --> Using HashMaps --> Least Optimized 
     * 
     * @param s
     * @param t
     * @return
     */
    public static boolean solution(String s, String t) {
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

}
