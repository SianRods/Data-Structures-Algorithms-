import java.util.Arrays;

public class MaximizeTheSumOfTheArray {
    public static void main(String[] args) {
        int arr[] = { -8, 3, -5, -3, -5, -2 };
        System.out.println(largestSumAfterKNegations(arr, 6));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        if(nums[0]<0){
            int i = 0;
             while (k != 0 || ){

             }
        }
        


        int i = 0;
        while (k != 0 && i < nums.length) {
            if (nums[i] >= 0 || nums[i - 1] < 0 && nums[i] >= 0) {
                nums[i] = nums[i] * (int) Math.pow(-1, k);
                break;
            } else if (nums[i] < 0) {
                nums[i] = -1 * nums[i];
                k--;
                i++;
            } else if (nums[i - 1] < 0 && nums[i] >= 0) {
                nums[i - 1] = nums[i - 1] * (int) Math.pow(-1, k);
                break;
            }
        }

        int sum = 0;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }

}
