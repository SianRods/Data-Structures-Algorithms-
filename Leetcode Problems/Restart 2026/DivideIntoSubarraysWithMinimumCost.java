import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.Collections;

public class DivideIntoSubarraysWithMinimumCost {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 12 };
        int arr[] = {10,3,1,1};
        minimimumCostDivision(arr);
    }

    public static int minimimumCostDivision(int nums[]) {
        int cost = 0;
        cost += nums[0];
        System.out.println(nums[0]);
        nums = Arrays.copyOfRange(nums, 1, nums.length );
        Arrays.sort(nums);

        cost += nums[0] + nums[1];
        System.out.println(nums[0]);
        System.out.println(nums[1]);
        return cost;

    }
}
