import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {

    }

    public void reverseArrayBounds(int nums[], int i, int j) {
        int temp = 0;
        while (i < j) {
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k %= n;
        reverseArrayBounds(nums, 0, n - 1);
        reverseArrayBounds(nums, 0, k - 1);
        reverseArrayBounds(nums, k, n - 1);

    }
}
