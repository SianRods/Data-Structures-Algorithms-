// 74. Search a 2D Matrix
// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.
// Meaaning that the matrix is completely sorted 

// You must write a solution in O(log(m * n)) time complexity.

public class SearchMatrix {
    public static void main(String args[]) {
        int arr[][] ={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(indexElement(arr, 13));

    }

    static boolean indexElement(int arr[][], int target) {
        // Here we are assuming n*n array but same can be done for a m*n array
        int r = 0;
        int c = arr[r].length - 1;

        while (r < arr.length) {
            if (arr[r][0] <= target && arr[r][c] >= target) {
                // Sending the required chunk of array for the binary search
                return binarySearchIndex(arr, r, c, target);
            } else {
                r++;
            }
        }
        // returning {-1,-1} if the element is not found
        return false;
    }

    static boolean binarySearchIndex(int arr[][], int r, int c, int target) {
        // Assuming the elements are sorted in Ascending sequence
        // creating two inner control variables i and j
        int start = 0;
        int end = arr[r].length - 1;
        int middle = (start + end) / 2;

        do {
            if (arr[r][middle] == target) {
                return true;
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
        return false;
    }

}
