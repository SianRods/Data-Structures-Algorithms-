import java.util.HashMap;
import java.util.Hashtable;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 1, 2, 3 };
        int k = 2;
        System.out.println(solution(nums, k) - solution(nums, k - 1));
    }

    // Here of instead of using an hasmap it can be made more optimized by using
    // frequency array

    public static int solution(int nums[], int k) {
        // number of good subarrays with atmost k different integers
        int n = nums.length;
        int i = 0;
        int j = 0;
        int count = 0;
        Hashtable<Integer, Integer> hm = new Hashtable<>();

        while (j < n) {
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);

            // violation of condition size > k
            while (hm.size() > k && i <= j) {

                hm.put(nums[i], hm.get(nums[i]) - 1);
                if (hm.get(nums[i]) == 0) {
                    hm.remove(nums[i]);
                }
                i++;

            }

            count += (j - i) + 1;
            j++;
        }
        return count;

    }

}
