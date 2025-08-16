
package Codechef.Starters_199;

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        // Finding the max number location in the array;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            int freq[] = new int[n + 1];

            for (int i = 0; i < n; i++) {
                freq[sc.nextInt()]++;
            }

            int maxOccurence = 0;

            for (int i = 1; i <= n; i++) {
                if (freq[i] > maxOccurence)
                    maxOccurence = freq[i];
            }

            int sol = Math.min(n - freq[1], (n - maxOccurence) + 1);
            System.out.println(sol);

        }
    }
}