
// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/?envType=daily-question&envId=2025-06-13
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MinimizeMaximumDifference {
    public static void main(String[] args) {
        // int arr[] = { 10, 1, 2, 7, 1, 3 };
        // int p = 2;
        // int arr[] = { 4, 2, 1, 2 };
        // int p = 1;
        // int arr[] = { 3, 4, 2, 3, 2, 1, 2 };
        // int p = 3;
        int arr[] = { 5, 6, 0, 5, 4, 0, 0 };
        int p = 1;
        int answer = minimizeMax(arr, p);
        System.out.println(answer);
    }

    public static int minimizeMax(int[] nums, int p) {
        if (p == 0) {
            return 0;
        }
        // Applying Binary Search on the Possible Range of Numbers
        Arrays.sort(nums);
        int upperLimit = nums[nums.length - 1] - nums[0];
        int lowerLimit = 0;
        // Initializing the sol variable from the maximum Possible value of difference
        // in the array
        int sol = upperLimit;
        int middle;

        while (lowerLimit < upperLimit) {
            middle = lowerLimit + (upperLimit - lowerLimit) / 2;
            if (isValidThresholdDifference(middle, nums, p)) {
                sol = middle;
                upperLimit = middle - 1;
            } else {
                lowerLimit = middle + 1;
            }
        }

        return sol;

    }

    public static boolean isValidThresholdDifference(int val, int nums[], int p) {
        int i = 0;
        int count = 0;
        while (i < nums.length - 1) {
            if (Math.abs(nums[i] - nums[i + 1]) <= val) {
                count++;
                i = i + 2; // Not to consider the repititive pairs for difference
            }
            if (Math.abs(nums[i] - nums[i + 1]) > val) {
                i++;
            }
            if (count == p) {
                // So if the given threshold is valid then we can check if anylower valid
                // threshold exists
                return true;
            }
        }
        return false;
    }

}
