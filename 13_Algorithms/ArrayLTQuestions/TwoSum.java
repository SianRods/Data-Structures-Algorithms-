import java.util.Arrays;
import java.util.Hashtable;

public class TwoSum {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int nums[], int target) {
        Hashtable<Integer, Integer> hm = new Hashtable<>();

        for (int i = 1; i < nums.length; i++) {
            hm.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hm.get(target - nums[i]) != null && hm.get(target - nums[i]) != i) {
                return new int[] { i, hm.get(target - nums[i]) };
            }
        }

        return new int[] { -1, -1 };
    }

    public static int[] twoSumBinarySearch(int nums[], int target) {
        Arrays.sort(nums);
        
    }
}
