import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        solution(matrix);
        print2DArray(matrix);

    }

    public static void solution(int matrix[][]) {

        int n = matrix.length;

        performTransform(matrix);
        for (int i = 0; i < n; i++) {
            reverseArray(matrix[i]);

        }

    }

    public static void performTransform(int matrix[][]) {

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    public static void reverseArray(int arr[]) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

    }

    public static void print2DArray(int matrix[][]) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
