import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(pascalsTriangle(n));
    }

    public static List<List<Integer>> pascalsTriangle(int numberOfRows) {
        List<List<Integer>> li = new ArrayList<>();

        for (int i = 0; i < numberOfRows; i++) {
            ArrayList<Integer> newRow = new ArrayList<>();
        

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    newRow.add(1);
                } else {
            List<Integer> prevRow = li.get(i - 1);
                    newRow.add(prevRow.get(j) + prevRow.get(j - 1));
                }

            }

            // add the newRow to the list
            li.add(newRow);

        }
        return li;

    }
}
