public class LargestOddNumber {
    public static void main(String[] args) {
        String num = "372468";
        System.out.println(solution(num));
    }

    public static String solution(String num) {

        int n = num.length();
        int i = n - 1;

        while (i >= 0) {
            char c = num.charAt(i);
            if ((c - '0') % 2 != 0) {
                // if the number is odd
                return num.substring(0, i + 1);
            }
            i--;
        }

        return "";

    }
}
