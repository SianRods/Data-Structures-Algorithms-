import java.util.HashMap;

public class LongestSubarrayWithAtMostKFreq {
    public static void main(String[] args) {

    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int maxFreq = 0;
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (j < n) {
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(nums[j]));

            while (i < j && maxFreq > k) {
                if (hm.get(nums[i]) == maxFreq) {
                    maxFreq--;
                }
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) - 1);
                if (hm.get(nums[i]) == 0) {
                    hm.remove(nums[i]);
                }

                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;

    }

}
