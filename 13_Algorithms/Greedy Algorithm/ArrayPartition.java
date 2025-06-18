import java.util.Arrays;

public class ArrayPartition {
    public static void main(String[] args) {

    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i=i+2) {
            // Note that the list is already sorted in order so we have to only pick the starting point of 
            // the array int the pairs of Two 
            sum += nums[i];
        }

        return sum;

    }
}
