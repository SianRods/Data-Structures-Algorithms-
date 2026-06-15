import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int arr[] = { -1, 0, 1, 2, -1, -4 };
        System.out.println(solution2(arr));

    }

    /**
     * In the sorting + two-pointer approach for 3Sum, we first sort the array so
     * that we can efficiently apply the two-pointer technique and easily skip
     * duplicates.
     * Then, we fix one element arr[i] as the first element of the triplet and use
     * two pointers—left starting at i + 1 and right at the end of the array—to
     * search for
     * the other two numbers. We compute the sum of arr[i] + arr[left] + arr[right];
     * If the sum is zero, we store the triplet and move both pointers inward while
     * skipping duplicate values.
     * If the sum is less than zero, we move the left pointer forward to increase
     * the sum; if it is greater than zero,
     * we move the right pointer backward to decrease the sum. Repeating this
     * process for each valid i (while skipping duplicate values of i)
     * ensures all unique triplets are found in O(n²) time.
     * 
     * @param arr input array
     * @return returns the List of all Distinct Triplets present in the input array
     */

    public static List<List<Integer>> solution1(int arr[]) {
        Arrays.sort(arr);
        // detetcting the dulpicate triplets is very important
        // In this question we need to skip the duplicates at three locations i , j and
        // k
        int n = arr.length;

        List<List<Integer>> sol = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            // This is very important to skip the same start points as we can endup adding
            // the duplicate elements in the solution list
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    sol.add(List.of(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    // Skip duplicate j
                    while (j < k && arr[j] == arr[j - 1])
                        j++;

                    // Skip duplicate k
                    while (j < k && arr[k] == arr[k + 1])
                        k--;

                } else if (sum > 0) {
                    // because the values are already sorted we can use the above logic
                    // of shifting the pointers according to the total sum

                    k--;
                } else {
                    j++;
                }
            }

        }

        return sol;
    }

    /**
     * 
     * In the HashSet-based approach, we iterate through the array and fix one
     * element arr[i], then use a HashSet to store elements seen while scanning the
     * remaining part of the array.
     * For each arr[j],we compute the required third value -(arr[i] + arr[j]) and
     * check if it already exists in the set;
     * if it does, we form a triplet. To avoid duplicates, we sort each triplet
     * before adding it to a result set (like Set<List<Integer>>),
     * ensuring only unique triplets are returned.
     * 
     * @param arr --> Input Array
     * @return --> List of all the distinct arrays
     * 
     */
    public static List<List<Integer>> solution2(int arr[]) {
        int n = arr.length;

        // Note that it is very important to understand the Set<List<Integer>> in java
        // can detect the duplicate list like --> [2,1] , [2,1]
        // ** If and only if they are present in sorted order

        // Requires the Set to store distinct lists
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            // creating the set for each bounded iterations
            Set<Integer> scanBounds = new HashSet<>();
            for (int j = i + 1; j < n; j++) {

                int sum = -(arr[i] + arr[j]);
                if (scanBounds.contains(sum)) {
                    // All the lists inserted in the set must be in the sorted else the duplicates
                    // won't be detected
                    // and hence we will have to sort the triplet before adding them to the Set

                    List<Integer> triplet = Arrays.asList(arr[i], arr[j], sum);
                    Collections.sort(triplet);
                    st.add(triplet);

                }
                scanBounds.add(arr[j]); // add the new element to the set

            }

        }

        return new ArrayList<>(st);

    }

}