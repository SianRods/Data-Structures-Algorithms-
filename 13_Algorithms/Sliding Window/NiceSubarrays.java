public class NiceSubarrays {

    public static void main(String[] args) {
        // int arr[] = { 1, 1, 2, 1, 1 };
        // int arr[] = { 2, 4, 6 };
        int arr[] = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        // int k = 3;
        // int k = 1;
        int k = 2;

        System.out.println(countNiceArrays(arr, k));
    }

    public static int countNiceArrays(int nums[], int k) {
        return atLeastKOddNumbers(nums, k) - atLeastKOddNumbers(nums, k - 1);
    }

    // Atleast K Odd Numbersin the Subarrays
    public static int atLeastKOddNumbers(int[] nums, int k) {
        int i = 0;
        int n = nums.length;
        int j = 0;
        int count = 0;
        int subarray = 0;

        while (j < n) {
            if (nums[j] % 2 != 0)
                count++;

            while (i < j && count > k) {
                if (nums[i] % 2 != 0)
                    count--;
                i++;
            }
            subarray += (j - i) + 1;
            j++;
        }

        return subarray;

    }

}
