
// https://leetcode.com/problems/assign-cookies/description/
import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {

    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        // i >> pointer for the greed array
        // j >> pointer for cookies in a packet array

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
                j++;
            } else {
                j++;
            }

        }

        return i;

    }
}
