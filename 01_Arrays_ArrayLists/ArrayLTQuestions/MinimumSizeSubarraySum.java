

import java.util.Arrays;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int nums [] = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println("The Minimum Size of the Subarray required is : "+minSubArrayLen(213, nums));
    }

    // 3 Edge Cases
    // 1]. Given sum maybe present as an element in the mentioned array
    // 2]. Start from the last as we want minimum size array
    // 3]. Use Of Sorting Algorithms takin nlog(n) time --> QuickSort
    // 4].Maintain asum counter
    static int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
     
        // Check if the element exists using Binary Search 
        if(Arrays.binarySearch(nums, target)>=0){
            return 1;
        }


        int sum=0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum+=nums[i];
            if(sum>=target){
                return nums.length-i;
            }
        }

        return 0;

    }
}
