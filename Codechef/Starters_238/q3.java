package Codechef.Starters_238;

import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read the number of test cases

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            // construct array of length -> with certain constraints
            if ((n + 1) % 3 != 0) {
                System.out.println("-1");
            } else {
                int[] a = new int[n + 2];
                a[0] = 0;
                a[1] = 1; // Our starting "vibration"

                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    if (i > 1) {
                        // A[i+1] = A[i] - A[i-1]
                        // We use i-1 and i-2 logic to fill the current index i
                        a[i] = (a[i - 1] - a[i - 2] + m) % m;
                    }
                    sb.append(a[i]).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        }
        sc.close();

    }
}
