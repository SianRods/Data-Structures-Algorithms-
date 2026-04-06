import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public static void main(String[] args) {

    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int minDiff = Integer.MAX_VALUE;
        while (i < n - k) {
            minDiff = Math.min(nums[i + k - 1] - nums[i], minDiff);
            i++;
        }

        return minDiff;
    }
}
