package Codechef.Starters_199;

import java.util.Scanner;

public class cake {
    public static void main(String[] args) {
        // NNumber of ways of counting digits from
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int sol;
        if (A > B) {
            sol = (A - 1) * B;
        } else {
            sol = (B - 1) * A;
        }
        System.out.println(sol);

    }
}
