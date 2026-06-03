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

    /**
     * The Most optimized Solution which is similar in nature to prefix sum concept
     * Just keep a count of the cummulative zeros and shift the nonzero element
     * back by the total zeros encountered previously and replace the nonzero with
     * zero
     * 
     * @param arr
     * @return
     */

    public static int[] solution2(int arr[]) {
        int n = arr.length;
        int countZerosCum = 0;
        int j = 0;
        while (j < n) {
            if (arr[j] == 0) {
                countZerosCum++;
            } else {
                // for nonzero element
                // check how many zeros are present to shift it back
                if (countZerosCum > 0) {
                    arr[j - countZerosCum] = arr[j];
                    arr[j] = 0;
                }

            }
            j++;
        }

        return arr;

    }

    public static int[] sample(int arr[]) {
        int n = arr.length;
        int i = 0;
        int prevZero = -1;
        while (i < n) {
            if (arr[i] != 0 && prevZero != -1) {
                // swap both the things and update the

            }

        }

        return arr;
    }

}
