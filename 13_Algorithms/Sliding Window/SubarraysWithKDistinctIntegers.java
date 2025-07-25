import java.util.*;

public class SubarraysWithKDistinctIntegers {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 1, 2, 3 };
        // int arr[] = { 1, 2, 1, 3, 4 };
        int arr[] = { 6, 9, 11, 12, 3, 2, 6, 1, 13, 11, 7, 13, 12 };
        // int k = 2;
        // int k = 3;
        int k = 13;
        System.out.println(getCountGood(arr, k));

    }

    public static long getCountGood(int nums[], int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    // The below function will help us find atleast subarrays with k distinct
    // integers
    public static long helper(int[] nums, int k) {
        Hashtable<Integer, Integer> map = new Hashtable<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        long count = 0;
        while (j < n) {
            // First we will add the element directly
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (i < j && map.size() > k) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            count += (j - i) + 1;
            j++;

        }

        return count;

    }

}
