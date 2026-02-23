public class SearchRotatedSortedArrayTwo {
    public static void main(String[] args) {

    }

    public static boolean rotatedArrayTwo(int arr[], int target) {
        int index = pivotIndex(arr);

        // check the both the halfs and return the final answer
        int ans = binarySearchBounds(arr, target, 0, index);
        if (ans != -1) {
            return true;
        } else {
            ans = binarySearchBounds(arr, target, index + 1, arr.length - 1);
        }

        if (ans != -1) {

            return true;
        }

        return false;
    }

    public static int binarySearchBounds(int arr[], int x, int s, int e) {
        int start = s;
        int end = e;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {

                start = mid + 1;
            } else if (arr[mid] >= x) {
                end = mid - 1;
            }

        }

        return -1;
    }

    public static int pivotIndex(int arr[]) {
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

                /*
                 * Sample example for micmicing the following pivot at the start and at the end
                 * condition
                 * arr[2,0,0,1,2,2,2,2,2,2,2,2,2,2]
                 * here arr[0] is the pivot
                 */
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

}
