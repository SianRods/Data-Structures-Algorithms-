import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int arr[] = { 1, 0, -1, 0, -2, 2 };
        System.out.println(solution1(arr, 0));

    }

    public static List<List<Integer>> solution1(int arr[], int target) {
        Arrays.sort(arr);
        // detetcting the dulpicate triplets is very important
        // In this question we need to skip the duplicates at three locations i , j and k
        int n = arr.length;

        List<List<Integer>> sol = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicates in the first loop
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            for (int l = i + 1; l < n - 2; l++) {

                // skip duplicates in the second loop
                if (l > i + 1 && arr[l] == arr[l - 1])
                    continue;
                int j = l + 1;
                int k = n - 1;
                while (j < k) {
                    long sum = (long) arr[i] + arr[l] + arr[j] + arr[k];
                    if (sum == target) {
                        sol.add(List.of(arr[i], arr[l], arr[j], arr[k]));
                        j++;
                        k--;
                        // // Skip duplicate j
                        while (j < k && arr[j] == arr[j - 1])
                            j++;

                        // // Skip duplicate k
                        while (j < k && arr[k] == arr[k + 1])
                            k--;
                    } else if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }

            }

        }

        return sol;

    }

    public static List<List<Integer>> solution2(int arr[], int target) {
        return null;
    }
}
