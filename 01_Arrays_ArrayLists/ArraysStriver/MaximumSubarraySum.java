import java.util.Arrays;

public class MaximumSubarraySum {
    public static void main(String[] args) {

        // int nums[] = { 2, 3, 5, -2, 7, -4 };
        int nums[] = { -2, -3, -7, -2, -10, -4 };
        System.out.println(kadaneAlgorithm(nums));
        System.out.println(Arrays.toString(solution2(nums)));

    }

    /**
     * @param arr input array of integers
     * @return Given an integer array nums, find the subarray with the largest sum,
     *         and return its sum.
     */
    public static int kadaneAlgorithm(int arr[]) {

        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            currentSum = Math.max(arr[i],
                    currentSum + arr[i]);

            maxSum = Math.max(maxSum,
                    currentSum);
        }



        return maxSum;
    }

    /**
     * This is the modified version of the same kadane's problem were we also return 
     * the maximum sum subarray back 
     * 
     * @param arr input array
     * @return Subarray with the maxixmum sum
     */
    public static int[] solution2(int arr[]) {
        int sumCurrent = 0;
        int maximumSum = Integer.MIN_VALUE;
        int i = 0;
        int n = arr.length;
        int index = -1;
        for (; i < n; i++) {
            sumCurrent += arr[i];

            if (maximumSum < sumCurrent) {
                index = i;
                maximumSum = sumCurrent;
            }
            // check if the current sum decreases then ==> reset the current sum to zero
            if (sumCurrent < 0) {
                sumCurrent = 0;
            }

        }

        // In this approach we first simply track the start index for the maximum sum 
        // and as we know the maximum sum we simply try to add all the elements from the start 
        // point till we have the desired sum

        int j = index;
        int sum = 0;
        // Now that we have the latest pointer for the maximum sum
        for (; j >= 0; j--) {
            sum += arr[j];
            if (sum == maximumSum) {
                return Arrays.copyOfRange(arr, j, index + 1);
            }

        }

        return new int[] {};

    }

    /**
     * In this approach we leverage the simple mathematical maximization rule
     * 
     * z=x+y
     * and y(subarray_sum)=z(maximum)-x(minimum)
     * in order to maximize the subarray sum y we should maximize z and minimize x
     * This thought process is very similar in nature to Kadane's Algorithm
     * 
     * 
     * @return maxsum
     */
    public static int prefixSumApproach(int arr[]) {
        int prefixsum[] = new int[arr.length];
        int n = arr.length;

        int sum = 0;
        int j = 0;
        for (int num : arr) {
            sum += num;
            prefixsum[j++] = sum;
        }

        int minPrefixSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            // update the sum
            maxSum = Math.max(maxSum, prefixsum[i] - minPrefixSum);
            // update the min_prefix_sum
            minPrefixSum = Math.min(minPrefixSum, prefixsum[i]);

        }

        return maxSum;
    }

}
