public class RotatedArray {

    public static void main(String[] args) {

    }

    static int rotatedArraySearchElement(int arr[], int target) {
        int pivot = findPivotIndex(arr);
        int ans = binarySearch(arr, 0, pivot, target);
        if (ans != -1) {
            return ans;
        } else {
            ans = binarySearch(arr, pivot + 1, arr.length - 1, target);
            return ans;
        }

    }

    static int binarySearch(int arr[], int start, int end, int target) {
        int middle = start + (end - start) / 2;

        while (start <= end) {
            middle = start + (end - start) / 2;
            if (arr[middle] > target) {
                end = middle - 1;
            } else if (arr[middle] < target) {
                start = middle + 1;
            } else if (arr[middle] == target) {w
                return middle;
            }
        }
        return -1;
    }

    static int findPivotIndex(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int middle = start + (end - start) / 2;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (middle < end && arr[middle] > arr[middle + 1]) {
                return middle;
            }
            if (middle > start && arr[middle - 1] > arr[middle]) {
                return middle - 1;
            } else if (arr[middle] <= arr[start]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;

    }

}