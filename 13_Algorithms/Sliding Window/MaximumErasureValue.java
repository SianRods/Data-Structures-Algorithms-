import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public static void main(String[] args) {
        // int arr[] = { 4, 2, 4, 5, 6 };
        int arr[] = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
        System.out.println(maximumUniqueSubarray(arr));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int result = 0;
        Set<Integer> st = new HashSet<>();
        while (j < n) {
            while (j < n && !st.contains(nums[j])) {
                sum += nums[j];
                st.add(nums[j]);
                j++; 
            }

            result = Math.max(sum, result);
            while (i <= j && j < n && st.contains(nums[j])) {
                // Remvoing the element at the start and then we will update the set
                sum -= nums[i];
                st.remove(nums[i]);
                i++;
            }
        }

        return result;
    }
}
