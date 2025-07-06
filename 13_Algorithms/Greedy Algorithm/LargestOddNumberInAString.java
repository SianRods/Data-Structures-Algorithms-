public class LargestOddNumberInAString {
    public static void main(String[] args) {

    }

    public static String largestOddNumber(String num) {
        int j = num.length();
        int i = 0;

        for (; j >= 0; j--) {
            if ((int) num.charAt(j) % 2 != 0) {
                break;
            }
        }

        return num.substring(i, j + 1);
    }
}
