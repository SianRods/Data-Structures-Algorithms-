public class MinimumRotatedArray {
    public static void main(String[] args) {

    }

    /**
     * Note that all we have to do is check in which sorted part does the
     * mid lies and accordingly adjust the mid towards pivot
     * For each iteration determine : Is mid in the "before pivot" region or the
     * "after pivot" region?
     * 
     * @param arr
     * @return
     */
    public static int pivotElement(int arr[]) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // only two of the possible things can happen w.r.t the middle position
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            } else if (mid > start && arr[mid - 1] > arr[mid]) {
                return mid;
            } else if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            }

        }

        return -1;

    }
}
