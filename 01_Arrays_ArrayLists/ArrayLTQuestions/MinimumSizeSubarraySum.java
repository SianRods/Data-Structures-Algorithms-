// https://leetcode.com/problems/minimum-size-subarray-sum/description/

import java.util.Arrays;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 1, 2, 4, 3 };
        System.out.println("The Minimum Size of the Subarray required is : " + slidingWindow(7, nums));
    }

    // Hints will be given through sample example as well as through Question's
    // wordings
    // Here we have to use the concept of Sliding Windows
    // We have to minimize the number of Elements between any two pointers so that
    // their sum is
    // greater than or equal to the target element
    // Hints : POSITIVE INTEGERS

    // Algorithm - Sliding Window Algorithm

    static int slidingWindow(int target, int[] nums) {
        // Whenever there is a problem invloving Subset of Arrays or Subpart of Strings
        // Concept of Sliding Window is used to increase the efficiency of the algorithm
        // by maintaining two pointers
        // Left and Right pointers and we keep on subtracting and updating the previous
        // min value of subarray
        int i, j;
        int sum = 0, minLength = 0;
        for (j = 0, i = 0; j < nums.length; j++) {

            sum += nums[j];

            while(sum >= target) {
                // if it is starting point or minLength then previous one
                if (i == 0 || j - i + 1 < minLength) {
                    minLength = j - i + 1;
                }

                sum -= nums[i];
                i++;
            }

        }

        return minLength;

    }

    static int sumBetweenBounds(int nums[], int start, int end) {
        // Inclusive of Start and End
        int sum = 0;
        for (int k = start; k <= end; k++) {
            sum += nums[k];
        }

        return sum;
    }

    // Naive method includes the nested for loop and counting the minimum length
    // subarray
    // starting from each of the mentioned element
}
