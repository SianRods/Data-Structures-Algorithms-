import java.util.Arrays;

public class MaximumSubarraySum {
    public static void main(String[] args) {

        // int nums[] = { 2, 3, 5, -2, 7, -4 };
        int nums[] = {-2, -3, -7, -2, -10, -4};
        System.out.println(solution1(nums));
        System.out.println(Arrays.toString(solution2(nums)));

    }

    /**
     * @param arr input array of integers
     * @return Given an integer array nums, find the subarray with the largest sum,
     *         and return its sum.
     */
    public static int solution1(int arr[]) {
        int sumCurrent = 0;
        int maximumSum = Integer.MIN_VALUE;
        int i = 0;
        int n = arr.length;

        for (; i < n; i++) {
            sumCurrent += arr[i];

            if (maximumSum < sumCurrent) {

                maximumSum = sumCurrent;
            }
            // check if the current sum decreases then ==> reset the current sum to zero
            if (sumCurrent < 0) {
                sumCurrent = 0;
            }

        }

        return maximumSum;
    }

    /**
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

}
