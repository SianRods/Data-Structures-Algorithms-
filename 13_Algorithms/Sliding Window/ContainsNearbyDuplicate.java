import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        int n = nums.length;

        // Time Complexity of this Outer Loop is O(n)
        for (int i = 0; i < n; i++) {

            // Time Complexity of the Inner Loop is O(min(k,n))
            for (int j = i; j < n && Math.abs(i - j) <= k; j++) {
                if (nums[i] == nums[j] && i != j)
                    return true;
            }
        }

        return false;
    }

    public static boolean containsNearbyDuplicate2(int nums[], int k) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        int i = 0;
        int j = 0;

        // Initialising the Starting Window
        while (j <= k && j < n) {
            if (st.contains(nums[j])) {
                return true;
            } else {
                st.add(nums[j]);
            }
            j++;
        }

        while (j < n) {

            // Shifting the Window ;
            st.remove(nums[i++]);
            if (st.contains(nums[j]))
                return true;
            st.add(nums[j++]);

        }

        return false;

    }

}
