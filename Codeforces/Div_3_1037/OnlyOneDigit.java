package Codeforces.Div_3_1037;

import java.util.Scanner;

public class OnlyOneDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int x = sc.nextInt();
            int small = x;
            int digit = 0;
            while (x > 0) {
                digit = x % 10;
                small = Math.min(small, digit);
                x /= 10;
            }
            System.out.println(small);

        }
    }

}