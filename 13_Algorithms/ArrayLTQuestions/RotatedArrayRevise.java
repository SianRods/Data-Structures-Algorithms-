import java.util.Arrays;

public class RotatedArrayRevise {

    public static void main(String[] args) {
        // int nums[] = { 2, 5, 6, 0, 0, 1, 2 };
        // int nums[] = { 2, 2, 2, 3, 2, 2, 2 };
        int nums[] = { 1, 0, 1, 1, 1 };
        // int nums[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1 };
        // int nums[]={1,1,1,1,2,2,2,1,1,1};
        System.out.println("Pivot Index is at : " + findPivotWithDuplicates(nums));
        System.out.println("Checking the Existence of an Element in the Array" + checkIfElementExists(nums, 1));

    }

    /*
     * EDGE CASES FOR PIVOT INDEX
     * 1]. [1,2,3,4,5,6,7] -> [7,1,2,3,4,5, 6] PASS
     * 2].[1,2,3,4,5,6,7] PASS
     * 3].[5,6,7,7,1,2,3,4,5] PASS
     * 4]. [1,0,1,1,1]
     * 5].[s=1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,m=2,1,1,1,1,e=1]
     * 
     */

 static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                // Here we are also Incudling the condition for mid<end for the edge case where
                // there are no pivots and
                // the largest number is at the end
                // Cause if the pivot==middle==endElement --> IndexOutOfBounds Exception as we
                // are trying to acess mid+1
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static boolean checkIfElementExists(int nums[], int target) {
        int pivot = findPivotWithDuplicates(nums);

        // Note that pivot is always to be included in the left part of the array
        int leftIndex = Arrays.binarySearch(nums, 0, pivot + 1, target);
        if (leftIndex >= 0) {
            System.out.println(leftIndex);
            System.out.println("This is leftIndex methods");
            return true;
        }

        int rightIndex = Arrays.binarySearch(nums, pivot + 1, nums.length, target);
        if (rightIndex >= 0) {
            System.out.println("This is right methods");
            return true;
        }

        return false;
    }

    static int indexBinary(int arr[], int start, int end, int element) {
        int middle = start + (end - start) / 2;
        do {

            if (element == arr[middle]) {
                return middle;
            } else if (element > arr[middle]) {
                // Searching in the Remaining Upper Half by shifting the start pointer
                start = middle + 1;
                middle = (start + end) / 2;
            } else if (element < arr[middle]) {
                // Searching in the Remaining Upper Half by shifting the start pointer
                end = middle - 1;
                middle = (start + end) / 2;
            }

        } while (!(start > end));
        return -1;
    }

}
