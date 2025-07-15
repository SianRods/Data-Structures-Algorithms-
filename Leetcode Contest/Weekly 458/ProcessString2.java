public class ProcessString2 extends ProcessString {

    public static void main(String[] args) {
        String s = "a#b%*";

        System.out.println(processStr2(s, 3));
    }

    public static char processStr2(String s, long k) {
        long len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '*' && c != '#' && c != '%') {
                len++;
                continue;
            }
            if (c == '*' && len > 0)
                len--;
            if (c == '#')
                len *= 2;
        }

        // check if the k is within the bounds
        if (k >= len || k < 0)
            return '.';

        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                // In reverse, the result was one character longer before '*'
                len++;
            } else if (c == '#') {
                long prevLen = len / 2;
                if (k >= prevLen) {
                    k -= prevLen;
                }
                len = prevLen;
            } else if (c == '%') {
                k = len - 1 - k;
            } else if (c >= 'a' && c <= 'z') {
                if (len - 1 == k) {
                    return c;
                }
                len--;
            }

        }
        return '.';

    }
}
