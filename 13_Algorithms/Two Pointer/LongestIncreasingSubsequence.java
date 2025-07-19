public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }

    public static int lengthOfLIS(int[] nums) {
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            int internalC = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j])
                    internalC++;
            }
            cnt = Math.max(cnt, internalC);
        }

        return cnt;
    }
}
