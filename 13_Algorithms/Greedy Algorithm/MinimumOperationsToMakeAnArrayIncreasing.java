public class MinimumOperationsToMakeAnArrayIncreasing {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1 };
        minOperations(arr);
    }

    public static int minOperations(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                nums[i] += Math.abs(nums[i] - nums[i - 1]) + 1;
                System.out.println(nums[i]);
                count += nums[i] - nums[i - 1];
               
            }
        }

        return count;
    }

}
