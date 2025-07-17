import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int prev = 0;
        prev = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }

                if (sum < target) {
                    j++;
                } else {
                    k--;
                }

                if (Math.abs(target - prev) > Math.abs(target - sum)) {
                    prev = sum;
                }

            }

        }

        return prev;
    }
}
