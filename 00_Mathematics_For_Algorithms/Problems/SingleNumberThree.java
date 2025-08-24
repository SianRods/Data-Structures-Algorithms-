package Problems;

public class SingleNumberThree {
    // Being able to find the two distinct numbers in an array containing all the
    // numbers twice

    public static void main(String[] args) {

    }

    public int[] singleNumber(int[] nums) {
        // The Standard Approach involving the use of buckets can be implemented
        // it points towards the most optimal use of the buckets

        // 1] find the unequal bits in both the distinct numbers
        // 2] then try to seprate both the numbers by finding the one position
        // where both the digits differ in terms of the bit value at the same position

        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            res ^= nums[i];
        }

        int b1 = 0;
        int b2 = 0;

        int rightMost = res ^ (res & (res - 1));

        for (int i = 0; i < n; i++) {
            if ((nums[i] & rightMost) != 0) {
                b1 ^= nums[i];
            } else {
                b2 ^= nums[i];
            }
        }

        return new int[] { b1, b2 };
    }
}
