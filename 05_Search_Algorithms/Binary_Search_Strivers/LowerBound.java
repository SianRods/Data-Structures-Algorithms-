public class LowerBound {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3 };
        int x = 3;
        System.out.println(solution(arr, x));

    }

    /**
     * 
     * The Below Function is used for finding the lower bound in an
     * input array which is already sorted.
     * It gives the position where x can be inserted without breaking sorting.
     * It finds the first element that is not smaller than x.
     * First index i such that arr[i] ≥ x
     * It does not require x to exist in the array NECESSARILY
     * 
     * 
     * @param arr sorted array in Ascending/Descending order
     * @param x   the target value whose lower bound is to be found
     * @return the first index of occurence of element which is greater or equal to
     *         x
     * 
     */
    public static int solution(int arr[], int x) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] >= x) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return start;
        // can also return ans where both points to the same thing 

    }
}
