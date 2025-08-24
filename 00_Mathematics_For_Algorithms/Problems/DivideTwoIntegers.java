package Problems;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        // Diving the two integers using the dividend and divisors
        // also we have to round the answer to an int value only (GINT)

    }

    public static int divide(int dividend, int divisor) {
        // Handle overflow case directly
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Handle simple cases
        if (dividend == 0)
            return 0;
        if (divisor == dividend)
            return 1;

        // Work with longs to prevent overflow
        long dend = Math.abs((long) dividend);
        long visor = Math.abs((long) divisor);
        long ans = 0;

        // Division using bit shifts
        while (dend >= visor) {
            int count = 0;
            while (dend >= (visor << (count + 1))) {
                count++;
            }
            ans += 1L << count;
            dend -= visor << count;
        }

        // Apply sign
        if ((dividend > 0) ^ (divisor > 0)) {
            ans = -ans;
        }

        // Clamp result within integer bounds
        if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) ans;

    }

}
