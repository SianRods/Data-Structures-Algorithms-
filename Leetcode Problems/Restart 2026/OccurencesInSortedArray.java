public class OccurencesInSortedArray {
    public static void main(String[] args) {
        // int arr[]={2, 2 , 3 , 3 , 3 , 3 , 4};
        int arr[]={1, 1, 2, 2, 2, 2, 2, 3};
        int x=2;
        System.out.println(solution(arr, x));
    }

    /**
     * Understand the difference between Decreasing and Non-Decreasing in given
     * words
     * 
     * 
     * @param arr Sorted Array
     * @param x
     * @return
     */
    public static int solution(int arr[], int x) {
        return upperBound(arr, x) - lowerBound(arr, x) + 1;

    }

    // find the occurunces of element in a sorted array using the lower and the
    // upper bound
    public static int upperBound(int arr[], int x) {
        int start = 0;
        int end = arr.length - 1;

        if (end < 0)
            return -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] <= x) {

                start = mid + 1;
            } else if (arr[mid] > x) {
                end = mid - 1;
            }

        }
        if (start - 1 >= 0 && arr[start - 1] == x)
            return start - 1;
        return -1;

    }

    public static int lowerBound(int arr[], int x) {
        int start = 0;
        int end = arr.length - 1;
        if (end < 0)
            return -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] < x) {

                start = mid + 1;
            } else if (arr[mid] >= x) {
                end = mid - 1;
            }

        }

        if (start < arr.length && arr[start] == x)
            return start;
        return -1;

    }
}
