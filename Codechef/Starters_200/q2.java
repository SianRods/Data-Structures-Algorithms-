package Codechef.Starters_200;

import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < arr.length; i++)
                arr[i] = sc.nextInt();

            int count = 0;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] % 2 != arr[i] % 2) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
