package Codechef.Starters_199;

import java.util.*;

public class SubtractAndDivide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            Set<Integer> s = new HashSet<>();
            sol(n, s);
            System.out.println(s.size());

        }
    }

    public static void sol(int n, Set<Integer> s) {
        // Implementing it with iterative dfs
        Deque<Integer> ar = new ArrayDeque<>();
        ar.addLast(n);
        while (!ar.isEmpty()) {
            int curr = ar.removeLast();
            if (curr > 2 && s.add(curr - 2)) {

                sol(curr - 2, s);
            }

            if (curr > 1 && curr % 2 == 0 && s.add(curr / 2)) {

                sol(curr / 2, s);
            }
        }

    }
}
