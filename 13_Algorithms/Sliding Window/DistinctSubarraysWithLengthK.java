import java.util.HashMap;

public class DistinctSubarraysWithLengthK {
    public static void main(String[] args) {

    }

    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int maxSum = 0;
        int maxFreq = 0;
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (j < n) {
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(nums[j]));
            sum += nums[j];

            while (i < j && maxFreq > 1) {
                if (hm.get(nums[i]) == maxFreq) {
                    maxFreq--;
                }
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) - 1);
                if (hm.get(nums[i]) == 0) {
                    hm.remove(nums[i]);
                }
                sum -= nums[i];

                i++;
            }

            if (i < j && hm.size() > k) {
                sum -= nums[i];
                hm.remove(nums[i]);
                i++;
            }

            if (hm.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
            j++;
        }

        return maxSum;
    }

}
