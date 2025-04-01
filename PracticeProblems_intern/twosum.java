package PracticeProblems_intern;

import java.util.ArrayList;
import java.util.Arrays;

public class twosum {
    public static void main(String[] args) {
        // int arr[] = { 2, 7, 11, 15 };
        // int arr [] ={3,2,4};
        int arr[] ={3,3};
        int targetSum = 6;
        // Assuming Exact Single Solution
        System.out.println("The Indices mathcing the target sum are : "+Arrays.toString(indices(arr, targetSum)));
    }

    static int[] indices(int arr[], int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = (i + 1); j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

}