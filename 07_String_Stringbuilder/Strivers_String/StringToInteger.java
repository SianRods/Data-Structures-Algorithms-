public class StringToInteger {

    public static void main(String[] args) {

        // String s = "1337c0d3";
        // String s = "000013133";
        // String s = "00000-42a1234"; // expected is '0'
        String s = "-91283472332";
        // String s = "-115579378e25";
        // String s = "+-2";
        System.out.println(solution1(s));
    }

    public static int solution1(String s) {

        // Note that use the instead of using the string builder we can build the int
        // digit by digit
        // which is more prominent .

        s = s.trim(); // FIX 1: trim first
        int n = s.length();

        if (n == 0)
            return 0;

        boolean positive = true;
        int i = 0;

        // FIX 2: sign only allowed at index 0
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.charAt(i) == '-') {
                positive = false;
            }
            i++;
        }

        int result = 0;

        // skip leading zeros (your logic preserved)
        while (i < n && s.charAt(i) == '0') {
            i++;
        }

        // FIX 3: build number digit by digit with overflow check
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // overflow check --> While building the digit
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return positive ? result : -result;
    }

}
