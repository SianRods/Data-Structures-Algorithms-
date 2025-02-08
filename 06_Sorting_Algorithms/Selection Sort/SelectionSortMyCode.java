// Approach
// We will choose the maximum element from the avaiable array size and insert it into it's right position(last position 
// of the avaiable array size) we will keep on doing the same thing for all elements and reducing the array size at each step
// of proper insertion
//  Time Complexitiy --> O (n*2)

import java.util.Arrays;

public class SelectionSortMyCode {
    public static void main(String args[]) {
        int arr[] = { -5, -4,0, -3,- 2, -1 };
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int arr[]) {
        // using the Loop

        for (int i = 0; i < arr.length; i++) {
            // Checking the maximum element out of the array and inserting it at the right
            // postion
            int max = 0;
            int index = 0;
            for (int j = 1; j < arr.length - i; j++) {
                max = arr[0];
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;  
                } else {
                    continue;
                }
            }
            // After the loop condtion swapping the given maximum element at the desired
            // position
            int temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[index];
            arr[index] = temp;

        }
    }
}
