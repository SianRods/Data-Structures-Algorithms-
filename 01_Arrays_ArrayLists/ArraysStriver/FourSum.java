import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {

    }

    /**
     * prerequisite --> 3 Sum 
     * This is the most identical approach to the three sum question just adding one nested 
     * loop fixes the one more additional element to be considered 
     * 
     * 
     * 
     * @param arr
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int arr[], int target) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > 0 && arr[j] == arr[j - 1])
                    continue;

                int k = j + 1;
                int l = n - 1;
                while (k < l) {

                    int sum = target - (arr[i] + arr[j] + arr[k] + arr[l]);
                    if (sum == 0) {
                        sol.add(new ArrayList<>(List.of(arr[i], arr[j], arr[k], arr[l])));
                        k++;
                        l--;
                        while (k < l && arr[k - 1] == arr[k])
                            k++;
                        while (k < l && arr[l - 1] == arr[l])
                            l--;

                    } else if (sum > 0) {
                        k++; // increase the value of the windowed sum
                    } else {
                        l--; // lower the value of the windowed sum
                    }
                }

            }

        }

        return sol;

    }

}
