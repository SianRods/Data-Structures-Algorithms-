
// It is important to note that all 2D arrays may be symmectric hence concept of jagged arrays becomes very crucial 
//  jagged arrays and how to find the length on inner array
import java.util.Arrays;;

public class Search2DArray {
    public static void main(String args[]) {
        int numarr[][] = {
                { 34, 3, 5, 46, 5, 6 },
                { 243, 4, 5, 4, 32, -23, -4, -21 },
                { 234, 3, 5, 457, 584 }
        };
        System.out.println("The values is stored at index :" + Arrays.toString(searchIndexArray(numarr, -23)));
        System.out.println("The Maximum val in array is :" + searchMaxArray(numarr));
        System.out.println("The Minimum val in array is :" + searchMinArray(numarr));
    }
    // As there are two indices involved the dtype of the return array will be an
    // array itself
    // Note that here while we return the value we have to create and return an
    // object using the 'new' keyword of type int

    static int[] searchIndexArray(int arr[][], int ele) {
        // Checking the boundary conditions
        if (arr.length == 0) {
            return new int[] { -1, -1 };
        }

        else {
            for (int rows = 0; rows < arr.length; rows++) {
                for (int cols = 0; cols < arr[rows].length; cols++) {
                    if (arr[rows][cols] == ele) {
                        return new int[] { rows, cols };
                    }
                }
            }
        }

        // If no index if found
        return new int[] { -1, -1 };
    }

    // Finding the Maximum and minimum in 2D Array

    static int searchMaxArray(int arr[][]) {
        // Checking the boundary conditions
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        else {
            int max = Integer.MIN_VALUE;
            for (int rows = 0; rows < arr.length; rows++) {
                for (int cols = 0; cols < arr[rows].length; cols++) {
                    if (arr[rows][cols] > max) {
                        max = arr[rows][cols];
                    }
                }
            }
            return max;
        }

    }

    static int searchMinArray(int arr[][]) {
        // Checking the boundary conditions
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        else {
            int min = Integer.MAX_VALUE;
            for (int rows = 0; rows < arr.length; rows++) {
                for (int cols = 0; cols < arr[rows].length; cols++) {
                    if (arr[rows][cols] < min) {
                        min = arr[rows][cols];
                    }
                }
            }
            return min;
        }

    }

}
