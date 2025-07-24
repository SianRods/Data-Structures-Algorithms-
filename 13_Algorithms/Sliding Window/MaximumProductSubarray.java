public class MaximumProductSubarray {
    public static void main(String[] args) {
        // int arr[] = { 2, 3, -2, 4 };
        int arr[] = { -2, 0, -1 };
        // int arr[] = { 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10,
        // 10, 10, 10, 10, 0 };
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int i = 0;
        int j = 0;
        int subProd = 1;
        while (j < n) {
            subProd *= nums[j];
            while (i <= j && subProd < prod) {
                if (nums[i] != 0) {

                    subProd /= nums[i];
                }
                i++;
            }
            prod = Math.max(prod, subProd);

            j++;

        }

        return prod;
    }

}
