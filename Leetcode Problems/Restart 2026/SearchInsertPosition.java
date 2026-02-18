public class SearchInsertPosition {
    public static void main(String[] args) {

    }

    /**
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
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return end;
    }

}
