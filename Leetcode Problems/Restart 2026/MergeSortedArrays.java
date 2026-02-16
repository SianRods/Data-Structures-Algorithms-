import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 0, 0, 0 };
        int nums[] = { 2, 5, 6 };
        int m = 3;
        int n = 3;
        System.out.println(Arrays.toString(solution1(arr, m, nums, n)));
    }

    /**
     * The final sorted array should not be returned by the function, but instead be
     * stored inside the array nums1.
     * To accommodate this, nums1 has a length of m + n,where the first m elements
     * denote the elements that should
     * be merged, and the last n elements are set to 0 and should be ignored. nums2
     * has a length of n.
     * 
     * @param arr1 First Sorted Array
     * @param m    Size of the first sorted array
     * @param arr2 Second Sorted Array
     * @param n    Size of the Second Sorted array
     * @return Two sorted Array Merged without using any extra space
     * 
     */
    public static int[] solution1(int arr1[], int m, int arr2[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (arr1[i] >= arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }

        }

        // insert the remaining elements of array two
        // in the array1 using the kth pointer
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }

        return arr1;

    }

}
