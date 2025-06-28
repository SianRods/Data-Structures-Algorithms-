import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIterativeApproach {
    public static void main(String[] args) {

    }

    // [1,2,3,4]

    public static List<List<Integer>> createSubsetOfArrays(int arr[]) {
        List<List<Integer>> sol = new ArrayList<>();
        sol.add(new ArrayList<>());

        for (int num : arr) {
            int n = sol.size();
            for (int i = 0; i < n; i++) {
                // Creating a Copy of the solution's ith list ;
                List<Integer> internalList = new ArrayList<>(sol.get(i));
                internalList.add(num);
                sol.add(internalList);
            }
        }
        return sol;
    }


    // Subsets with containing duplicates of the elements 

    // CONTINUE THE VIDEO FROM 1:18:11 / 1:30:29 MINS TO PROPERLY UNDERSTAND THE SOLUTION 

}
