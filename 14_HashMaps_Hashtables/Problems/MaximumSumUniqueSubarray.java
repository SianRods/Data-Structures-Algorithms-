import java.util.HashSet;
import java.util.Set;

public class MaximumSumUniqueSubarray {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5 };
        // int arr[] = { 1, 1, 0, 1, 1 };
        int arr[] = { 1, 2, -1, -2, 1, 0, -1 };
        System.out.println(maxSum(arr));

    }

    public static int maxSum(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int n = nums.length;
        int i = 0;
        int neg = Integer.MIN_VALUE;
        while (i < n) {
            if (nums[i] >= 0) {
                st.add(nums[i]);
            } else {
                neg = Math.max(nums[i], neg);
            }
            i++;
        }

        if (st.isEmpty()) {
            // If the Set Remains Empty then all the elements inside the set are negative
            // in this case we have to return the least negative numbers
            return neg;
        } else {

            int sum = 0;
            for (Integer num : st) {
                sum += num;
            }

            return sum;
        }

    }

}
