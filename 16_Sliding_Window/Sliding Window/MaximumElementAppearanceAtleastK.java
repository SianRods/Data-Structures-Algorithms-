public class MaximumElementAppearanceAtleastK {
    public static void main(String[] args) {
        // int arr[] = { 1, 3, 2, 3, 3 };
        // int arr[] = { 1, 4, 2, 1 };
        // int k = 2;
        // int k = 3;
        int arr[] = { 28, 5, 58, 91, 24, 91, 53, 9, 48, 85, 16, 70, 91, 91, 47, 91, 61, 4, 54, 61, 49 };
        int k = 1;

        System.out.println(countSubarrays(arr, k));
    }

    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        long subarr = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        i = 0;

        while (j < n) {
            if (nums[j] == max)
                count++;

            // The inner loop should run until i<=j in edge cases where k==1
            while (i <= j && count >= k) {
                if (nums[i] == max) {
                    count--;
                }
                subarr += (n - j);
                i++;
            }

            j++;
        }

        return subarr;

    }
}
