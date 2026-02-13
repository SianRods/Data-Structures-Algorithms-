import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        int rows = 5;
        System.out.println(solution1(rows));
    }

    public static List<List<Integer>> solution1(int rows) {
        List<List<Integer>> sol = new ArrayList<>();

        sol.add(new ArrayList<>(List.of(1)));
        rows--;
        // start from --> index i==1
        for (int i = 1; i <= rows; i++) {
            List<Integer> rowInsert = new ArrayList<>();

            List<Integer> prevRow = sol.get(i - 1);

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    rowInsert.add(j, 1);
                } else {
                    int preSum = prevRow.get(j - 1) + prevRow.get(j);
                    rowInsert.add(j, preSum);
                }

            }

            sol.add(i, rowInsert);

        }

        return sol;

    }

}