public class ArithmeticSlices {
    public static void main(String[] args) {
        // int arr[] = { 1, 3, 5, 7, 9 };
        int arr[] = { 1, 2, 3, 4 };
        System.out.println(numberOfArithmeticSlices(arr));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return 0;
        int i = 0;
        int j = 1;
        int count = 0;

        int diff = nums[j] - nums[i];
        while (j < n) {
            while (j < n && diff + nums[j - 1] == nums[j]) {
                j++;
            }

            if (j - i >= 3) { // It should be greater than or equal to three cause when the above loop ends
                // the jth pointer is already pointing towards subarray+1 size
                int len = j - i;
                count += ((len - 2) * (len - 1)) / 2;

            }

            if (j < n) {
                // Updating the difference and exploring the next possible sequence
                diff = nums[j] - nums[j - 1];
                i = j - 1;

            }

        }

        return count;
    }
}
