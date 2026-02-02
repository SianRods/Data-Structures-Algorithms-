import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(solution(nums));
    }

    public static int solution(int nums[]) {
        int n = nums.length;
        int i = 0;
        int j = 0;

        while (j < n) {
            // if unique element found at j
            if (nums[i] != nums[j] && i <= j) {
                nums[++i] = nums[j];

            }
            j++;

        }
        System.out.println(Arrays.toString(nums));

        return i + 1;

    }
}
