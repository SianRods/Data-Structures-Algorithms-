import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AllKDistantIndicesInAnArray {
    public static void main(String[] args) {
        // Sample nums = [3,4,9,1,3,9,5], key = 9, k = 1
        int nums[] = { 2, 2, 2, 2, 2 };
        // int nums[]={3,4,9,1,3,9,5};
        int key = 2;
        int k = 2;
        System.out.println(findKDistantIndices(nums, key, k));

    }

    // A k-distant index is
    // an index i of nums for which there exists at least one index j
    // such that |i - j| <= k and nums[j] == key.

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        // Stop the right pointer
        int i = -1;
        int j = 0;
        List<Integer> sol = new ArrayList<>();
        int n = nums.length;

        while (j < n && i < n) {
            if (nums[j] != key) {
                while (j < n && nums[j] != key) {
                    j++;
                }
            } else {
                i++;
            }
            // Checking whether the i'th element is eligible or not
            if (nums[j] == key && Math.abs(i - j) <= k) {
                sol.add(i);

            } else if (i > j) {
                // Here we are only moving ahead the jth pointer and scanning for the next
                // occurence of the
                // key element iff the condition of (i-j)<=k gets violated
                j++;
            }

        }

        return sol;

    }

    public static List<Integer> naiveSolutionfindKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> indices = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                indices.add(i);
            }
        }

        for (Integer j : indices) {
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(i - j) <= k) {
                    // Inorder to avoid adding duplicates we can use hashmap for storing the value
                    // once
                    hm.put(i, j);
                }
            }
        }
        List<Integer> sol = new ArrayList<>(hm.keySet());
        Collections.sort(sol);
        return sol;

    }

}
