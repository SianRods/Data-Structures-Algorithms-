import java.util.Arrays;

public class MinimumOperationsToMakeBinaryArray {

    public static void main(String[] args) {
        // int arr[] = { 0, 1, 1, 1, 0, 0 };
        int arr[] = { 0, 1, 1, 1 };
        System.out.println(minOperations(arr));
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int i = 0;
        int ops = 0;
        int j = 0;

        while (i < n - 2) {
            System.out.println(Arrays.toString(nums));
            while (i < n - 2 && nums[i] != 0) {
                i++;
            }
            System.out.println("The value of the i pointer is : " + i);
            if (nums[i] == 0) {
                ops++;
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
            }
            i++;
        }

        // Checking if there exists any 0 in the array or not
        for (; j < n; j++) {
            if (nums[j] == 0)
                return -1;
        }
        return ops;
    }
}