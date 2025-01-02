import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 } };
        // System.out.println(arr);
        System.out.println(Arrays.toString(indexElement(arr, 8)));
    }

    static int[] indexElement(int arr[][], int target) {
        // Here we are assuming n*n array but same can be done for a m*n array
        int r = 0;
        int c = arr.length - 1;

        while (r < arr.length) {
            if (arr[r][0] <= target && arr[r][c] >= target) {
                // Sending the required chunk of array for the binary search
                return binarySearchIndex(arr, r, c, target);
            } else {
                r++;
            }
        }
        // returning {-1,-1} if the element is not found
        return new int[] { -1, -1 };
    }

    static int[] binarySearchIndex(int arr[][], int r, int c, int target) {
        // Assuming the elements are sorted in Ascending sequence
        // creating two inner control variables i and j
        int start = 0;
        int end = arr.length - 1;
        int middle = (start + end) / 2;

        do {
            if (arr[r][middle] == target) {
                return new int[] { r, middle };
            } else if (arr[r][middle] > target) {
                end = middle - 1;
                middle = (start + end) / 2;
            } else {
                start = middle + 1;
                middle = (start + end) / 2;
            }
        } while (!(start > end));
        // Else returning {-1,-1}
        // As the element is not found
        return new int[] { -1, -1 };
    }

}