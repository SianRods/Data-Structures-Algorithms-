public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        // String s = "cbbd";
        String s = null;
        System.out.println(solution1(s));
    }

    public static String solution1(String s) {
        // if the string is empty returh null;
        // note that if the string is null .length function is not defined;
        if (s == null || s.length() == 0)
            return "";

        int n = s.length();
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            // considering the odd length palindromic strings
            int arr[] = getLength(s, i, i, n);
            if (right - left < arr[1] - arr[0]) {
                left = arr[0];
                right = arr[1];
            }

            // for even length palindromic strings
            arr = getLength(s, i, i + 1, n);
            if (right - left < arr[1] - arr[0]) {
                left = arr[0];
                right = arr[1];
            }

        }

        return s.substring(left, right + 1);

    }

    public static int[] getLength(String s, int left, int right, int n) {

        while ((left >= 0 && right < n) && (s.charAt(left) == s.charAt(right))) {

            left--;
            right++;
        }

        return new int[] { ++left, --right };
    }

    /**
     * The most optimized solution for generating all
     * lengths of all the palindromic strings
     * time complexity --> O(N)
     * 
     * 
     * @param s
     * @return
     */
    public static String manachersAlgorithm(String s) {
        return null;
    }

}