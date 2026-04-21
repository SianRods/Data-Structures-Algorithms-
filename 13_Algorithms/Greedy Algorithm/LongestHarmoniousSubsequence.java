import java.util.Arrays;
import java.util.Hashtable;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {

    }

    public static int findLHS(int[] nums) {
        // Here the language of the question is littel bit twisted else the question
        // is actually easier to undertand when we anaylse what we have to actually
        // return and not we are suppose to do

        // Here as we ahave to analyse the sunsequence maximum and minimum distance to
        // be 1
        // we can just sort the array and try applying the two pointers method to solve
        // it
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        // Local Final Variables
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = 0;
        while (j < nums.length) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[j]);
            if (max - min == 1 || max - min == 0) {
                j++;
            }

        }

        return -1;
    }

    public static int findLHSHashtableMethod(int[] nums) {
        Hashtable<Integer, Integer> hm = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.get(nums[i]) != null) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
                continue;
            }
            // else just add a single character
            hm.put(nums[i], 1);
        }

        Arrays.sort(nums);
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            if (hm.get(nums[j]) != null && hm.get(nums[j] + 1) != null) {
                res = Math.max(res, hm.get(nums[j]) + hm.get(nums[j] + 1));
            }
        }

        return res;
    }

}
