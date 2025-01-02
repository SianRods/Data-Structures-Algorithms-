import java.lang.reflect.Array;
import java.util.Arrays;

// It is important to note that as this matrix is not purely sorted we won't be able to apply binary search here
// and can only decrease the search space accordingly  





public class RowColMatrixMyCode {
    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 } };
        // System.out.println(arr[1].length);
        // afrray.length returns the size of the first dimension of an array
        System.out.println(Arrays.toString(indexPosition(arr, 9)));
    }

    static int[] indexPosition(int arr[][], int target) {
        int rows = 0;
        int cols = arr[0].length - 1;

        while (rows < arr.length && cols >= 0) {
            // We have to perform three checks
            if (arr[rows][cols] == target) {
                return new int[] { rows, cols };

            }
            if (arr[rows][cols] < target) {
                rows++;
            } else {
                cols--;
            }
        }
        return new int[] { -1, -1 };
    }
}
