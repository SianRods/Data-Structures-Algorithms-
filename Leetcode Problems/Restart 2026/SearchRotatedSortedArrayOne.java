public class SearchRotatedSortedArrayOne {
    public static void main(String[] args) {
        // int arr[] = {4,5,6,7,0,1,2};
        int arr[] = { 3, 1 };
        int target = 3;
        System.out.println(solution1(arr, target));
    }

    /**
     * Although this uses the brute force approach of dividing the array into two
     * parts
     * It does not satisfy the time constrain requirements of problem --> O(Logn)
     * 
     * This solution yeilds a O(n) time complexity due to search of the pivot index
     * 
     * @param arr    sorted array
     * @param target target element to be searched
     * @return returning the position of the target element
     * 
     */
    public static int solution1(int arr[], int target) {
        int k = findRotatedIndexOne(arr);
        int n = arr.length;
        System.out.println("The pivot index is " + k);
        if (target >= arr[k] && target <= arr[n - 1]) {
            // search in the second half of the array --> the rotated part
            return binarySearchBounds(arr, target, k, n - 1);
        } else if (k > 0 && arr[0] <= target) {
            return binarySearchBounds(arr, target, 0, k - 1);

        } else {
            return binarySearchBounds(arr, target, 0, n - 1);
        }

    }

    /**
     * This function takes the input array and finds the pivot index in O(n) time
     * complexity
     * which is not the best possible scenario considering we already know binary
     * search and
     * can implement the similar logic of binary search --> for finding out the
     * pivot elment
     * in O(log n) time complexity
     * 
     * @param arr
     * @return
     */
    public static int findRotatedIndexOne(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                return i;
            }

        }

        // else if not rotated return 0
        return 0;

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

    /**
     * Most important part to understand in this question is maintaining a time
     * complexity
     * of O(logn) always in every situation
     * Only Algo which helps maintains this time complexity if O(logn)
     * and hence we must implement binarysearch() in a way that we find pivot
     * Finding Pivot() --> must be smartly implemented in O(logn) time complexity
     * to maintain the overall time complexity of O(logn) in the question asked
     * 
     * @param arr    --> possibly rotated array
     * @param target --> target index to check on
     * @return --> index of the target element if it exists else == -1
     */
    public static int solution2(int arr[], int target) {
        int pivot = findRotatedIndexTwo(arr);
        // Search in the first half part
        int ans = binarySearchBounds(arr, target, 0, pivot);

        // if ans does not exists if the first half --> check the second half
        if (ans != -1) {
            return ans;
        } else {
            ans = binarySearchBounds(arr, target, pivot + 1, arr.length - 1);
        }

        return ans;
    }

    /**
     * Searching the pivot in O(logn) time complexity
     * 
     * @param arr --> input possibly rotated
     * @return --> index of the pivot is it exists
     */
    public static int findRotatedIndexTwo(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // scene one of fidning pivot
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // scene two of finding pivot
            if (start < mid && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            }

            else if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        // if the pivot is not found returns --> -1
        return -1;

    }

}
