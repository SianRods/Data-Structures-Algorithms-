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

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] <= x) {
                start = mid + 1;
            } else if (arr[mid] > x) {
                end = mid - 1;
            }

        }

        
        return start;
    }
}
