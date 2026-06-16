public class SingleElement {
    public static void main(String[] args) {

    }

    /**
     * 
     * In this solution we are actually shrinking the bounds towards the half
     * of the array with odd size and the shrinking takes place considering the size
     * of the pairs=1 --> s=m+2/e=m-2 accordingly
     * 
     * @param arr
     * @return
     */
    public static int getSingleElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Handling the single case properly
            if ((mid == 0 || arr[mid] != arr[mid - 1]) &&
                    (mid == arr.length - 1 || arr[mid] != arr[mid + 1])) {
                return arr[mid];
            }

            // pair ends before
            if (mid > 0 && arr[mid] == arr[mid - 1]) {

                int elementsBeforePair = (mid - 1) - start;

                if (elementsBeforePair % 2 == 0) {
                    start = mid + 1;
                } else {
                    end = mid - 2;
                }
            }

            // pair ends after
            else {

                int elementsBeforePair = mid - start;

                if (elementsBeforePair % 2 == 0) {
                    start = mid + 2;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * Optimal Method 2 : Finding the pattern of start indices being even | odd
     * @param arr
     * @return
     */
    public static int oddEvenMethod(int arr[]) {

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((mid == 0 || arr[mid] != arr[mid - 1]) &&
                    (mid == arr.length - 1 || arr[mid] != arr[mid + 1])) {
                return arr[mid];
            }

            if (mid % 2 == 1) {
                mid--;
            }

            if (mid < end && arr[mid] == arr[mid + 1]) {
                // no single element has occured yet
                // and the possible single element lies to the right side of the mid
                start = mid + 2;
            } else {
                // Pattern breaks here
                end = mid;
            }

        }
        return -1;
    }
}
