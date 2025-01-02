// 1095. Find in Mountain Array
// You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
// MountainArray.get(k) returns the element of the array at index k (0-indexed).
// MountainArray.length() returns the length of the array.
// Submissions making more than 100 calls to MountainArray
// .get will be judged Wrong Answer. 
// Also, any solutions that attempt to circumvent the judge will result in disqualification.

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

public class MountainArray {
    public static void main(String args[]) {

    }

    // The order of MountainArray is first ascending then descending
    // find index and then apply binary search about that index that's ot
    // return the minimum index if the element exists
    // return -1 if the element does not exists

    static int findInMountainArray(MountainArray mountainArr, int element) {

        int start = 0;
        int end = pivotIndexMountainArray(mountainArr);
        int middle = (start + end) / 2;

        if (mountainArr.length() > 1) {

            do {

                if (element == mountainArr.get(middle)) {
                    return middle;
                } else if (element > mountainArr.get(middle)) {
                    start = middle + 1;
                    middle = (start + end) / 2;
                } else if (element < mountainArr.get(middle)) {
                    end = middle - 1;
                    middle = (start + end) / 2;
                }

            } while (!(start > end));
        } else {
            start = pivotIndexMountainArray(mountainArr);
            end = mountainArr.length() - 1;
            do {

                if (element == mountainArr.get(middle)) {
                    return middle;
                } else if (element < mountainArr.get(middle)) {
                    // Searching in the Remaining Upper Half by shifting the start pointer
                    start = middle + 1;
                    middle = (start + end) / 2;
                } else if (element > mountainArr.get(middle)) {
                    // Searching in the Remaining Upper Half by shifting the start pointer
                    end = middle - 1;
                    middle = (start + end) / 2;
                }

            } while (!(start > end));
        }

        return -1;

    }

    static int pivotIndexMountainArray(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        int middle = (start + end) / 2;

        do {
            if (mountainArr.get(middle + 1) - mountainArr.get(middle) < 0) {
                if (mountainArr.get(middle) - mountainArr.get(middle - 1) > 0) {
                    return middle;
                } else {
                    end = middle - 1;
                    middle = (start + end) / 2;
                }
            } else if (mountainArr.get(middle + 1) - mountainArr.get(middle) >= 0) {
                start = middle + 1;
                middle = (start + end) / 2;
            }
        } while (!(start > end));
        return -1;
    }
}
