// https://leetcode.com/problems/minimum-size-subarray-sum/description/

import java.util.Arrays;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int nums[] = { 12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12 };
        System.out.println("The Minimum Size of the Subarray required is : " + minSubArrayLen(213, nums));
    }


    // Hints will be given through sample example as well as through Question's wordings 
    // Here we have to use the concept of Sliding Windows 
    // We have to minimize the number of Elements between any two pointers so that their sum is 
    // greater than or equal to the target element 
    // Hints : POSITIVE INTEGERS 

    // Algorithm - Sliding Window Algorithm


    static int minSubArrayLen(int target, int[] nums) {

    }

    // Naive method includes the nested for loop and counting the minimum length subarray 
    // starting from each of the mentioned element 
}
