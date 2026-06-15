// we have to figure out on by comparing two elements only if the array is sorted in ascending 
// descending order
// We have to compare the starts and the last element cause both the simultaneous elements can be same/ equal
// [4,4,4,13,134,4675,246436] 
// Figure out the question being talked about 

public class BinarySearch {
    public static void main(String args[]) {
        int arr[] = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(binarySearchRecursive(arr, 0, arr.length-1, target));
    }

    // implemented using the basic assumption of ascending array
    // also remember that we do have to apply the condition of start<=end
    // denoting with '=' is very important
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2; // avoiding the integer overflow condition
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return -1;// element does not exists
    }

    // implementing the recursive form of the binary search basic assumption of
    // Ascending order
    public static int binarySearchRecursive(int arr[], int start, int end, int target) {
        // base condition
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] >= target) {
                return binarySearchRecursive(arr, start, mid - 1, target);
            } else {
                return binarySearchRecursive(arr, mid + 1, end, target);
            }

        }
        return -1;

    }
}
