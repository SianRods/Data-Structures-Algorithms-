// Approach
// We will choose the maximum element from the avaiable array size and insert it into it's right position(last position 
// of the avaiable array size) we will keep on doing the same thing for all elements and reducing the array size at each step
// of proper insertion
//  Time Complexitiy --> O (n*2)

import java.util.Arrays;

public class SelectionSortMyCode {
    public static void main(String args[]) {
        int arr[] = { -5, -4, 0, -3, -2, -1 };
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
