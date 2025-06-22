import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MinimumSubsequenceInNonDecreasingOrder {
    public static void main(String[] args) {

    }

    public static List<Integer> bruteForceminSubsequence(int[] nums) {
        List<Integer> sol = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int maxSum = 0;
        int minLength = 0;
        int sumTill = 0;

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length && sumTill <= sum) {
                sumTill += nums[j];
                j++;
            }

            // Check if it satisfies the possible subsequence condition
            if ((j - i + 1) > minLength) {
                if (sumTill > maxSum) {
                    // Save the indices here
                }
            }
        }
    }

    public static List<Integer> greedySolutionMinSubsequence(int[] nums) {
        // Here the {3,4,8,9,10}
        // we have to return the answer sorted in Non-decreasing order
        Arrays.sort(nums);
        List<Integer> sol = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int sumTill = 0;
        for (int i = nums.length - 1; i >= 0; i--) {

            sumTill += nums[i];

            sol.add(nums[i]);

            if (sumTill > (sum - sumTill)) {
                break;
            }

        }
        return sol;
    }

}