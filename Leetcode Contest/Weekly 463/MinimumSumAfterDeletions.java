
public class MinimumSumAfterDeletions {

    public long minArraySum(int[] nums, int k) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }

        int i = 0;
        int n = nums.length;
        long sumInternal = 0;

        while (i < n) {
            sumInternal += nums[i];
            if (sumInternal % k == 0) {
                total -= sumInternal;
                sumInternal = 0;
            }
            i++;

        }

        return total;

    }
}