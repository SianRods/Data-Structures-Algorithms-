public class SmallestDivisorGivenThreshold {

    public static void main(String[] args) {

    }

    /**
     * 
     * 
     * // The only thing we have to decide here is the range of the divisors to
     * check on
     * // Threshold defines the sum of all the dividends -->> by smallest divisor
     * // sum<=threshold --> always
     * 
     * 
     * goal is to minimize the divisor
     * Note that in case of binary search question only thing which differs is
     * deciding the kind of bound question which is involved and range of all the
     * possible answers
     * on which we are suppose to apply binary search
     * 
     * 
     * @param nums      array of all the integer numbers
     * @param threshold the maximum value of the dividend sum permissble for
     *                  minimizing the divisor
     * @return returns the minimum value of
     */

    public static int solution(int[] nums, int threshold) {
        int n = nums.length;

        int max_divisor = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            max_divisor = Math.max(max_divisor, nums[i]);
        }

        // goal is to minimize the divisor
        int start = 1;
        int end = max_divisor;
        int result = 0;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (satisfies(nums, mid, threshold)) {
                result = mid;
                // keep finding the smaller divisor still
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return -1;
    }

    public static boolean satisfies(int nums[], int mid, int threshold) {
        // scan the entire array and check whether it fits under the given conditions of
        // the questions
        int sum = 0;
        for (Integer ele : nums) {
            sum += Math.ceilDiv(ele, mid);

        }

        return sum <= threshold;

    }

}