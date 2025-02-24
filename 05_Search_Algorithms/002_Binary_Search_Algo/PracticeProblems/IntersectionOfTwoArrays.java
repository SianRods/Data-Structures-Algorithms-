import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public static void main(String args[]) {

    }

    static int[] intersection(int[] nums1, int[] nums2) {
        int[] temp = new int[Math.min(nums1.length, nums2.length)];

        // Sorting the Second array
        quicksort(nums2, 0, nums2.length);
        int i;
        for (i = 0; i < nums1.length; i++) {
            if (BinarySearch(nums2, nums1[i])) {
                temp[i] = nums1[i];
            }
        }

        return Arrays.copyOf(temp, i);

    }

    static boolean BinarySearch(int arr[], int target) {
        int s = 0;
        int e = arr.length - 1;
        int middle = s + (e - s) / 2;

        while (s < e) {
            if (arr[middle] > target) {
                e = middle - 1;
            } else if (arr[middle] < target) {
                s = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    static void quicksort(int arr[], int start, int end) {

        if (start < end) {
            int middle = partition(arr, start, end);
            quicksort(arr, start, middle - 1);
            quicksort(arr, middle + 1, end);
        }
    }

    static int partition(int arr[], int start, int end) {

        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        int temp;

        while (i <= j) {
            while (i <= end && arr[i] <= pivot)
                i++;
            while (j > start && arr[j] > pivot)
                j--;
            if (i < j) {

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[j];
        arr[j] = arr[start];
        arr[start] = temp;

        return j;
    }

}
