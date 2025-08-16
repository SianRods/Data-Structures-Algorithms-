package Codechef.Starters_199;

import java.util.*;

public class Brick {
    public static void main(String[] args) {
        // Finding the max number location in the array;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int maxLoc = 0;
            int maxEle = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int ele = sc.nextInt();
                if (ele > maxEle) {
                    maxEle = ele;
                    maxLoc = i;
                }
            }

            System.out.println(maxLoc + 1);

        }
    }
}
