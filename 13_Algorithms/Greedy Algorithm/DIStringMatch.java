// package 13_Algorithms.Greedy Algorithm;

import java.util.Arrays;

public class DIStringMatch {

    public static void main(String[] args) {
        // String s = "IDID";
        // String s = "III";
        String s = "DDI";
        System.out.println(Arrays.toString(DIMatch(s)));

    }

    public static int[] DIMatch(String di) {
        int n = di.length();
        int arr[] = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        int i = 0;
        while (i < n) {

            if (di.charAt(i) == 'I') {
                // If the char is I then we will just increment the pointer ahead
                i++;
            } else {

                // A pointer to maintain where the previous D started before counting
                // consecutive D's
                int prev = i;

                // Handling the Decreasing Values Continously
                while (i < n && di.charAt(i) == 'D') {
                    i++;
                }

                // Here we will be reversing the entire segment
                reverseSegment(arr, prev, i);

            }

        }

        return arr;

    }

    private static void reverseSegment(int arr[], int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
