public class SplitAStringInBalancedStrings {
    public static void main(String[] args) {

    }

    public static int balancedStringSplit(String s) {
        // Because the quantity of r and l in the strings is same hence we can conlude
        // that
        // all the strings can be perfectly be splitted in a balanced substrings
        int r = 0;
        int l = 0;
        int result = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == 'R') {
                r++;
            } else {
                l++;
            }

            if (r == l) {
                r = 0;
                l = 0;
                result++;
            }

            i++;
        }

        return result;

    }
}
