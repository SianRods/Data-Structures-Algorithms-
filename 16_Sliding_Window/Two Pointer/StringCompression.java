import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {

        // char chars[] = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        char chars[] = { 'a', 'b', 'c' };
        System.out.println(compress(chars));
        System.out.println(Arrays.toString(chars));
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int j = 0;
        // int count = 1;
        int k = 0;
        while (j < n) {

            while (j < n && k < n && chars[j] == chars[k]) {
                k++;
            }

            int dist = updateChar(i, chars, k - j, j);
            i = dist;

            j = k;
        }

        if (n == 1)
            return 1;

        return i;
    }

    private static int updateChar(int i, char[] chars, int count, int charLoc) {
        if (count == 1) {
            chars[i++] = chars[charLoc];
        } else {
            String cnt = Integer.toString(count);
            chars[i++] = chars[charLoc];
            for (int m = 0; m < cnt.length(); m++) {
                chars[i++] = cnt.charAt(m);

            }

        }
        return i;
    }
}
