import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubintervals {
    public static void main(String[] args) {
        int arr[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        print2D(solution1(arr));

    }

    public static int[][] solution1(int[][] intervals) {
        // Being greedy and sorting on the basis of the start index
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;

        List<List<Integer>> sol = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                // Add first interval directly
                sol.add(List.of(intervals[i][0], intervals[i][1]));
            } else {

                List<Integer> prev = sol.get(sol.size() - 1);

                // Check overlap
                if (prev.get(1) >= intervals[i][0]) {

                    int start = prev.get(0);
                    int end = Math.max(prev.get(1), intervals[i][1]);

                    // Replace last interval with merged interval
                    sol.remove(sol.size() - 1);
                    sol.add(List.of(start, end));

                } else {
                    // add non-overlapping interval
                    sol.add(List.of(intervals[i][0], intervals[i][1]));
                }
            }
        }

        return convertTo2DArray(sol);

    }

    public static int[][] convertTo2DArray(List<List<Integer>> list) {
        int[][] arr = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            List<Integer> inner = list.get(i);
            arr[i] = new int[inner.size()];

            for (int j = 0; j < inner.size(); j++) {
                arr[i][j] = inner.get(j); // auto-unboxing Integer -> int
            }
        }

        return arr;
    }

    public static void print2D(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(); // move to next row
        }
    }

}
