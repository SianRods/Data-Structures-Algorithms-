import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Set<Integer> set = new HashSet<>();

            for (int i = 1; i <= n; i++) {
                int type = sc.nextInt();
                set.add(type);
            }

            System.out.println(m - set.size());

        }

    }
}
