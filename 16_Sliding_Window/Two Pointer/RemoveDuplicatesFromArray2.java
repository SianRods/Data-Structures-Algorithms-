public class RemoveDuplicatesFromArray2 {
    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int count = 0;
        while (right < len) {
            count = 1;

            while (right + 1 < len && nums[right] == nums[right + 1]) {
                right++;
                count++;
            }

            for (int i = 0; i < Math.min(2, count); i++) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        return left;

    }
}
