

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> sol = new ArrayList<>();
        // Sort the Array First
        Arrays.sort(arr);
        // Running a Loop to find the Minimum Value of the Difference
        int minDifference = Math.abs(arr[arr.length - 1] - arr[0]); // initialising with maximum difference
        int i = 0;
        while (i < arr.length - 1) {
            if (Math.abs(arr[i + 1] - arr[i]) < minDifference) {
                minDifference = Math.abs(arr[i + 1] - arr[i]);
                i++;
            } else {
                i++;
            }
        }
        i = 0;
        while (i < arr.length - 1) {
            if (Math.abs(arr[i + 1] - arr[i]) == minDifference) {
                // Add to the Solution List
                sol.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
                i++;
            } else {
                i++;
            }
        }

        return sol;

    }
}
