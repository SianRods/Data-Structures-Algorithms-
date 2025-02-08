// Use cases and Complexity of the algorithm 
// 1. Works really well for Partially Sorted arrays 
// 2. Use in case of Hybid sorting algorithms 
// 3. Best Case Time Complexity is --> O(N) i.e Linear
// 4. Worst Case Time Complexity is --> O(N**2) i.e quadratic

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] ={5,4,3,2,1};
        insertionSort(arr);
        System.err.println(Arrays.toString(arr));
    }

    static void insertionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = (i + 1); j > 0; j--) {
                // Sorting in Ascending Order
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else if (arr[j - 1] < arr[j]) {
                    // Elements are already sorted till the given limit 
                    break;
                }
            }
        }
    }

}
