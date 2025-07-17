import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            boolean status = false;
            int n = sc.nextInt();
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int score = sc.nextInt();
                sum += score;

                if ((sum / (i + 1)) < 40) {
                    System.out.println("NO");
                    status = true;

                }
            }

            if (!status) {
                System.out.println("YES");
            }

        }

    }
}
