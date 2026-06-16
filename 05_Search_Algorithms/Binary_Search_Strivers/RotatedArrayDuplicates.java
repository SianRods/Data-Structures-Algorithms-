public class RotatedArrayDuplicates {
    public static void main(String[] args) {
        // int arr[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1 };
        // int target = 2;
        int arr[] = { 1, 0, 1, 1, 1 };
        int target = 0;
        System.out.println(rotatedArrayDuplicates(arr, target));
    }

    /**
     * 
     * Notice that it is important to understand what problem does having duplicates
     * in the array pose
     * the thing is in rotated-array-1 we were clear about which part is sorted in
     * the array left or right
     * and as per the sorted part we would determine whether that part of the array
     * contains the element and
     * accordingly adjust the bounds
     * 
     * But in this variation of the same question the only confusion/ambiguity arise
     * in detecting the sorted part
     * there is one particular case were we can't determine definitively which part
     * is sorted and which one is not
     * and in such situation it is always better to remove the ambiguity |
     * non-deterministic nature and then
     * we can apply similar logic to that of part 1 rotated sorted array
     * 
     * Time complextiy -> Best Case O(Logn) ; Worst Case O(n) (ambiguity removal)
     * Space Complexity -->O(1)
     * 
     * 
     * 
     * @param arr
     * @param target
     * @return true/false whether the given element is present in the array or not
     */
    public static boolean rotatedArrayDuplicates(int arr[], int target) {

        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == target) {
                return true;
            }

            if (arr[s] == arr[m] && arr[m] == arr[e]) {
                // total ambiguity and hence we would defo have to remove it first and then
                // continue
                // figuring out which part of the array is actually sorted out
                s++;
                e--;
            }

            else if (arr[s] <= arr[m]) {
                // left part is sorted check if the target lies within the bounds
                if (arr[s] <= target && arr[m] > target) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else {
                // left part is sorted check if the target lies within the bounds
                if (arr[e] >= target && arr[m] < target) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }

        }
        return false;
    }





        /**
         * Most confusing and unecessary code implementation using the Pivot method and
         * very heavy constraint
         * 
         * @param arr
         * @param target
         * @return
         */
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
