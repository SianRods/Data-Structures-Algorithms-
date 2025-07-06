import java.util.Arrays;

public class MaximizeTheSumOfTheArray {
    public static void main(String[] args) {
        int arr[] = { -8, 3, -5, -3, -5, -2 };
        System.out.println(largestSumAfterKNegations(arr, 6));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        while (k != 0 && i < nums.length) {
            if (nums[i] < 0) {
                nums[i] *= -1;
                Arrays.sort(nums);
                continue;
            }
            if (nums[i] > 0) {
                nums[i] *= Math.pow(-1, k);
                break;
            }
            i++;
            k--;

        }

        int sum = 0;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }

}
