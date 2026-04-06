import java.util.Arrays;

public class MovingStonesUntilConsecutive {
    public static void main(String[] args) {

    }

    public static int[] numMovesStones(int a, int b, int c) {
        int rangeLeft = 0;
        int rangeRight = 0;
        int arr[] = { a, b, c };
        Arrays.sort(arr);

        rangeRight = arr[2] - arr[1] - 1;
        rangeLeft = arr[1] - arr[0] - 1;
        int minMoves = 0;

        // If already Consecutive
        if (rangeLeft == 0 && rangeRight == 0) {
            minMoves = 0;
        } else if (rangeLeft <= 1 || rangeRight <= 1) {
            // either of the endpoint will be shifted directly in the ranhge gap with <=1
            minMoves = 1;
        } else {
            minMoves = 1;
        }

        return new int[] { minMoves, rangeLeft + rangeRight };

    }
}
