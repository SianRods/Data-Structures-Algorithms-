import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        print2DArray(matrix);
        System.out.println(solution(matrix));

    }

    public static List<Integer> solution(int matrix[][]) {
        List<Integer> sol = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (left <= right && top <= bottom) {
            // left → right
            for (int i = left; i <= right; i++) {
                sol.add(matrix[top][i]);
            }
            top++;

            // top → bottom
            for (int j = top; j <= bottom; j++) {
                sol.add(matrix[j][right]);
            }
            right--;

            // right → left (only if row still exists)
            if (top <= bottom) {
                for (int k = right; k >= left; k--) {
                    sol.add(matrix[bottom][k]);
                }
                bottom--;
            }

            // bottom → top (only if column still exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    sol.add(matrix[i][left]);
                }
                left++;
            }
        }

        return sol;

    }

    public static void print2DArray(int matrix[][]) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    

}
