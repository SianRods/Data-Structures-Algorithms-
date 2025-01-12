import java.util.Scanner;

public class PowerOfN {
    public static void main(String args[]) {

    }
    // X = 2;
    // n = -2;

    static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }

        if (n == 0) {
            return 0;
        }

        double result = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                // If the factor of two cannot be removed then we have to just multiply it with
                // the preceeding result
                result *= x;
            }
            x *= x;

            // Reduing the base by a factor of two
            n /= 2;

        }

        return result;
    }
}

// --------------------------------------------------------------------------------
// Initial Way of Dealing with the problem :- Which is unoptimized and has
// significant performance issuse issues
// if (n < 0) {
// x = 1 / x;
// n = Math.abs(n);
// }
// if (n == 0) {
// return 1;
// }

// return myPow(x, n - 1) * x;