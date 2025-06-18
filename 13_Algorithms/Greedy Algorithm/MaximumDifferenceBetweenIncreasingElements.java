public class MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {

    }

    public static int maximumDifference(int[] nums) {

        int maxDifference = -1;
        int j = 0;
        // Going till the second last element
        for (int i = 0; i < nums.length - 1; i++) {
            j = i + 1;
            while (j < nums.length) {
                // Check for the valid number
                if (nums[j] > nums[i] && nums[j] - nums[i] > maxDifference) {
                    maxDifference = nums[j] - nums[i];
                }
                j++;
            }
        }
        return maxDifference;
    }
}
