public class LongestEvenOddSubarray {
    public static void main(String[] args) {
        // int nums[] = { 3, 2, 5, 4 };
        // int k = 5;

        int nums[] = { 1, 2 };
        int k = 2;

        System.out.println(longestAlternatingSubarray(nums, k));
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int i = 0;
        int j = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] <= threshold && nums[i] % 2 == 0)
                break;
            i++;
        }
        j = i;
        int maxLen = 0;

        while (j < n - 1) {
            if (nums[j] % 2 != nums[j + 1] % 2 && nums[j] <= threshold) {
                maxLen = Math.max(maxLen, j - i + 2);
                j++;
            } else {
                i = j;
                while (i < n) {
                    if (nums[i] <= threshold && nums[i] % 2 == 0)
                        break;
                    i++;
                }
                j = i;
            }

        }

        if (i < n && nums[i] <= threshold) {
            maxLen = Math.max(maxLen, 1);
        }

        return maxLen;
    }
}
