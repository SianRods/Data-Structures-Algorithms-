public class ValidPalindrome2 {
    public static void main(String[] args) {

    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean flag = false;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j) && !flag) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }

        }

        return true;

    }

}
