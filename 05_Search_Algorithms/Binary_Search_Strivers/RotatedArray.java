public class RotatedArray {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        // int arr[] = { 3, 1 };
        int target = 0;
        System.out.println(rotatedArray(arr, target));
    }

    /**
     * Optimal Part 1 : Checking which part of the array is sorted
     * once we find which part of the array is sorted then accordingly we can
     * check further if that sorted part contains the target element or not and
     * adjust the
     * bounds accordingly so the entire thought process is to figure out which part
     * of the array is sorted and adjust the bounds based on whether the target
     * element
     * lies within those bounds or not
     * 
     * @param arr
     * @param target
     * @return
     */
    public static int rotatedArray(int arr[], int target) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == target) {
                return m;
            } else if (arr[s] <= arr[m]) {
                // left part is sorted check if the target lies within the bounds
                if (arr[s] <= target && arr[m] > target) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else if (arr[m] <= arr[e]) {
                // left part is sorted check if the target lies within the bounds
                if (arr[e] >= target && arr[m] < target) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }

        }
        return -1;
    }

    /**
     * 
     * Optimal Solution 2: Finding the Pivot element directly
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
    public static int rotatedArrayPivot(int arr[], int target) {
        int pivot = findRotatedIndex(arr);
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
    public static int findRotatedIndex(int arr[]) {
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

}
