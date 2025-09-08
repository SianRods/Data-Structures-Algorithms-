package Codeforces.DIV_3_1037;

import java.util.Scanner;

public class NoCasino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            // Taking the input of the arrays ;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int count = 0;
            int baddays = 0;

            for (int i = 0; i < k; i++) {
                if (arr[i] == 1)
                    baddays++;
            }

            int i = 0;
            while (i <= n - k) {
                if (baddays == 0) {
                    i += k + 1;
                    count++;
                    baddays = 0;

                    // Testing the window ahead
                    for (int j = i; j < i + k && j < n; j++) {
                        if (arr[j] == 1) {
                            baddays++;
                        }
                    }
                } else {
                    // Shifting the window ahead by one step to try the next day
                    if (arr[i] == 1)
                        baddays--;
                    if (i + k < n && arr[i + k] == 1) {
                        baddays++;
                    }
                    i++;
                }

            }

            System.out.println(count);
        }
    }

}
