public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { -1, 0, 3, 5, 9, 12 };
        System.out.println(bsSolution1(arr, 2));
    }

    public static int bsSolution1(int arr[], int target) {
        // Applying Binary Search on a Sorted Array

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;

    }

}
