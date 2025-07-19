
public interface ConsecutiveOnes {
    public static void main(String[] args) {

    }

    public static int longestOnes(int[] nums, int k) {

        // here the only difference is that when the number of zeros>k then we don't
        // update the max length
        // till the number of zeros <=k we just move the left ++ and the right pointer
        // cause as long as
        // k condition is not met we will never be able to update max length variable
        // thus locking the window
        // size when zeros>k and hence have

        int maxLength = 0;
        int count = 0;
        int i = 0;
        int n = nums.length;
        int j = 0;

        while (j < n) {
            if (nums[j] == 0)
                count++;
            if (count > k) {
                if (nums[i] == 0)
                    count--;
                i++;
            }
            if (count <= k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }

        return maxLength;

    }
}
