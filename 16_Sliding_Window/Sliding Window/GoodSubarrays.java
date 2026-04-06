import java.util.HashMap;

public class GoodSubarrays {
    public static void main(String[] args) {
        // int arr[] = { 1, 1, 1, 1, 1 };
        int arr[] = { 3, 1, 4, 3, 2, 2, 4 };
        int k = 2;
        System.out.println(countGood(arr, k));
    }

    public static long countGood(int[] nums, int k) {
        // This question can be solved using an Hashmap
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        int count = 0;
        long ans = 0;

        while (j < n) {
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);

            int f = hm.get(nums[j]);
            // Here a Valid Pair Can be Formed
            if (f >= 2)
                count += f - 1;

            while (i < j && count >= k) {
                ans += (n - j);

                int g = hm.get(nums[i]);
                if (g >= 1) {
                    hm.put(nums[i], g - 1);
                    count -= (g - 1);

                }
                i++;
            }
            j++;
        }

        return ans;

    }

}
