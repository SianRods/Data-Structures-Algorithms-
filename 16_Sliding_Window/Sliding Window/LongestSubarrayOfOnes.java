public class LongestSubarrayOfOnes {
    public static void main(String[] args) {

    }

    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int i = 0;
        int j = 0;
        int count = 1;
        while (j < n) {
            if (nums[j] == 0)
                count--;

            while (i < j && count < 0) {
                if (nums[i] == 0)
                    count++;
                i++;
            }

            if (count >= 0) {
                maxLen = Math.max(maxLen, (j - i) + 1);
            }
            j++;

        }

        return maxLen;
    }
}
