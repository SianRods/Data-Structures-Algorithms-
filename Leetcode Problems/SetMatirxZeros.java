import java.util.Arrays;

public class SetMatirxZeros {
    public static void main(String args[]) {
        // m*n Matrix --> Set Row and Column for the corresponding zero to be 0
        // Solution having O(n*2) Complextiy
        // int arr[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

        int arr[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

        System.out.println("Matrix Before Refinement");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        refineMatrix(arr);
        System.out.println("Matrix After Refinement");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }

    static void refineMatrix(int arr[][]) {
        // Searching in an unsorted matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    makeZero(arr, i, j);
                    return;
                }
            }
        }

    }

    static void makeZero(int arr[][], int row, int col) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == row || j == col) {
                    arr[i][j] = 0;
                }
            }
        }
    }

}
