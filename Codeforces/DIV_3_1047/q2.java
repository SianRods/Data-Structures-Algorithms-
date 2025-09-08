import java.util.*;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long maxEven = -1;

            // Collect divisors efficiently
            ArrayList<Long> divisors = new ArrayList<>();
            for (long i = 1; i * i <= b; i++) {
                if (b % i == 0) {
                    divisors.add(i);
                    if (i != b / i) divisors.add(b / i);
                }
            }

            // Check each divisor
            for (long k : divisors) {
                long res = a * k + b / k;
                if (res % 2 == 0) {
                    maxEven = Math.max(maxEven, res);
                }
            }

            System.out.println(maxEven);
        }
    }
}
