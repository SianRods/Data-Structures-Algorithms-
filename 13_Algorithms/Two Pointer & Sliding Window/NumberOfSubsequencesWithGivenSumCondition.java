import java.util.Arrays;

public class NumberOfSubsequencesWithGivenSumCondition {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 7 };
        // int arr={3,3,6,8};
        // int arr[]={2,3,3,4,6,7};
        int target = 9;
        System.out.println(numSubseq(arr, target));
    }

    public static int numSubseq(int[] nums, int target) {
        // Using most Naive Solution and can be optimized later
        // We actually dont care about generating the original subsequence which
        // satisfies the condtion
        // so we can actually sort the given array
        Arrays.sort(nums);
        int totalCount = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] <= target) {
                    totalCount++;
                }
            }
            totalCount+=Math. 
        }

        return totalCount;

    }
}
