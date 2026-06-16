public class UpperBound {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 8, 9, 15, 19 };
        int x = 9;
        System.out.println(solution(arr, x));

    }

    /**
     * 
     * 👉 First index i such that arr[i] > x
     * It finds the first element strictly greater than x.
     * Used to count duplicates efficiently.
     * 
     * @param arr
     * @param x
     * @return
     */
    public static int solution(int arr[], int x) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] > x) {
                ans = mid;
                end = mid - 1;
            } else {
                // Now as compared to the lower bound question the 
                // equality constraint is shifted in this part of the code / else statement
                start = mid + 1;
            }

        }

        return start;
        // similar to returning ans;
    }
}
