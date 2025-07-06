import java.util.Arrays;


public class kthLargestInnumsay {
    public static void main(String[] args) {
        int nums[] = { 3, 2, 1, 5, 6, 4 };
        findkthLargest(nums, 1);
        System.out.println(Arrays.toString(nums));
    }

    static void findkthLargest(int nums[], int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i < n / 2; i++) {
            temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }

        return nums[k - 1];

    }
}