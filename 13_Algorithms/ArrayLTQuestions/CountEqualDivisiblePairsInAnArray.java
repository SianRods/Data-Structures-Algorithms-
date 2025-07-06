// https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/description/?envType=daily-question&envId=2025-04-17
public class CountEqualDivisiblePairsInAnArray {
    public static void main(String[] args) {

    }

    static int countPairs(int[] nums, int k) {
        // Check for every possible values of (i,j)
        // time Complextiy -> O(N*2)
        // Sorting won't work cause we want order to be preserved
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;      
                }
            }
        }

        return count;
    }

}
