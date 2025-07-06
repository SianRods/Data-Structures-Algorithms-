public class SortArrayByParity {
    public static void main(String[] args) {

    }

    public int[] sortArrayByParity(int[] nums) {
        // Simple Two Pointer Approach where we have to swap the elements from both ends
        int i = 0;
        int n = nums.length;
        int j = n - 1;
        int temp = 0;
        while (i < j) {
            while (nums[i] % 2 == 0) {
                i++;
            }
            while (nums[j] % 2 == 1) {
                j--;
            }
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;

        }

        return nums;
    }
}
