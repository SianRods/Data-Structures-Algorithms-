// package Codeforces.DIV_3_1043;

import java.util.Scanner;
import java.util.ArrayList;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int lenA = sc.nextInt();
            sc.nextLine(); // consume leftover newline
            String a = sc.nextLine();

            int lenB = sc.nextInt();
            sc.nextLine(); // consume leftover newline
            String b = sc.nextLine();

            String c = sc.nextLine();

            StringBuilder res = new StringBuilder(a);
            // If v==> append at the start
            // if d==> append at the end

            for (int i = 0; i < lenB; i++) {
                if (c.charAt(i) == 'V') {
                    res.insert(0, b.charAt(i));
                } else {
                    res.append(b.charAt(i));
                }
            }

            System.out.println(res);

        }

    }
}
