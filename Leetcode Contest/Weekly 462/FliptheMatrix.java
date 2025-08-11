import java.util.Arrays;

public class FliptheMatrix {

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));

            arr = reverseSubmatrix(arr, 1, 0, 3);
            display(arr);

        }
    }

    public static void display(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int maxX = x + (k - 1); // maxX=3
        int maxY = y + (k - 1); // maxY=2

        for (int j = y; j <= maxY; j++) {
            System.out.println(j);
            reverseColumn(grid, j, x, maxX);
        }

        return grid;

    }

    private static void reverseColumn(int[][] grid, int j, int x,  int maxX) {
        int i = x;  // x=1
        int k = maxX; //x=3
        while (x < maxX) {
            System.out.println("The value of i in loop is "+i);
            System.out.println("The value of j in loop is "+j);
            System.out.println("The value of k in loop is "+k);

            int temp = grid[i][j]; //x =1 
            grid[i][j] = grid[k][j];
            grid[k][j] = temp;
            i++;
            k--;
        }
    }
}
