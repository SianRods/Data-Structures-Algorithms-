public class SmallestDivisorThreshold {

    public static void main(String[] args) {

    }

    /**
     * write the entire logic behind max element in paragraph format
     * The upper bound of the binary search is chosen as the maximum element of the
     * array because any divisor greater than the maximum element does not produce a
     * new or better result. In this problem, for a given divisor d, we calculate
     * the sum of ceil(arr[i] / d) for every element. If d becomes equal to the
     * maximum element in the array, then every element is less than or equal to d.
     * As a result, each term ceil(arr[i] / d) evaluates to 1, since dividing a
     * positive number by an equal or larger positive number produces a value
     * between 0 and 1, whose ceiling is 1. Therefore, the total sum becomes exactly
     * the number of elements in the array. If we further increase the divisor
     * beyond the maximum element, every array element is still less than the
     * divisor, so each ceiling value remains 1 and the total sum does not decrease
     * any further. Since larger divisors behave exactly the same as the maximum
     * element, searching beyond max(arr) is unnecessary. Thus, the answer, if it
     * exists, must lie within the range [1, max(arr)], making max(arr) the tightest
     * and most efficient upper bound for the binary search.
     * 
     * 
     * 
     * @param arr
     * @param threshold
     * @return
     */
    public static int getSmallestDivisor(int arr[], int threshold) {

        int n = arr.length;
        int start = 1;
        int end = 0;

        for (int ele : arr) {
            end = Math.max(end, ele);
        }
        int sol = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            // check whether the given answer satisfies the condition or not
            for (int i = 0; i < n; i++) {
                sum += Math.ceilDiv(arr[i], mid);
            }

            // check if the answer is possible or not
            if (sum <= threshold) {
                sol = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return sol;
    }

}