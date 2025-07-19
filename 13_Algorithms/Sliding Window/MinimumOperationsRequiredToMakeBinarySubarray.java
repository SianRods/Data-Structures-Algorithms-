public class MinimumOperationsRequiredToMakeBinarySubarray {
    public static void main(String[] args) {

    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i; j < i + 3; j++) {
                if (nums[j] == 0) {
                    nums[j] = 1;
                } else {
                    nums[j] = 0;
                }
            }
            ops++;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }

        return ops;

    }
}
