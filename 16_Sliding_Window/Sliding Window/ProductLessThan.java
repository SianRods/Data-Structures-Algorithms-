public class ProductLessThan {
    public static void main(String[] args) {
        int arr[] = { 10, 5, 2, 6 };
        // int arr[] = { 1, 2, 3, 4, 5 };
        int k = 100;
        // int k = 1;
        System.out.println(numSubarrayProductLessThanK(arr, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int i = 0;
        int j = 0;
        int count = 0;
        int n = nums.length;
        int prod = 1;

        while (j < n) {
            prod *= nums[j];

            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }

            count += j - i + 1;
            j++;

        }

        return count;
    }
}
