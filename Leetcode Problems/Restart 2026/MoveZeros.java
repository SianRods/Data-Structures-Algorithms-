import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        // int arr[] = { 0, 1, 0, 3, 12 };
        int arr[] = { 2, 1 };

        System.out.println(Arrays.toString(solution(arr)));
    }

    /**
     * Given an integer array nums,
     * move all 0's to the end of it while maintaining the
     * relative order of the non-zero elements.
     * 
     * @param nums[] Array
     * @return Arrays containing all the zeros at the last mainitaing relative order
     */
    public static int[] solution(int nums[]) {

        int n = nums.length;

        int lastIndex = -1;

        for (int i = 0; i < n; i++) {

            // shitfing the nonzero element only if there exists lastMinIndex
            if (nums[i] != 0 && lastIndex != -1) {

                // swap both the parties
                nums[lastIndex] = nums[i];
                nums[i] = 0;
                lastIndex++;
            }

            if (nums[i] == 0 && lastIndex == -1) {
                lastIndex = i;
            }

        }

        return nums;

    }

}
