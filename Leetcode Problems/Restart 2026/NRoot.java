

public class NRoot {

    public static void main(String[] args) {
        // int nums = 50;
        // System.out.println(squareRoot(nums));
        System.out.println(nthRoot(69, 4));
    }

    /**
     * Takes a postive number as a input and returns the
     * square root of the given number by applying binary seach on the search space
     * of all the possible answers from (1,n) note that we do have to consider
     * greatest number less than or equal to square root of the given number
     * 
     * @param num Input Positive Number
     * @return Floor of the square root of the given number
     */
    public static int squareRoot(int num) {
        int start = 1;
        int end = num;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sq = mid * mid;
            if (sq == num) {
                return mid;
            } else if (sq > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return end;
    }

    /**
     * 
     * Searching the Space is the only way we can reduce the time complexity from
     * Linear to logarithmic
     * so we would use the binary search on the answer space to find the middle and
     * then
     * compute it's n power till it reaches the num if while computing ans> num -->
     * stop fast
     * to save the compute time --> and only exit if mid^n == num --> return the mid
     * 
     * @param n   nth root to be found out
     * @param num Input Positive Number
     * @return returns the n'th root of the given else -1 if the nth root does not
     *         exist
     */
    public static int nthRoot(int num, int n) {
        int start = 1;
        int end = num;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Using long to fix the integer overflow error 
            long nthRoot = 1;

            for (int i = 1; i <= n; i++) {
                nthRoot *= mid;
                if (nthRoot > num) {
                    break; // exit early from the loop

                }
            }

            if (nthRoot == num) {
                return mid;
            } else if (nthRoot < num) {
                // shift the search space ahead
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;

    }

}