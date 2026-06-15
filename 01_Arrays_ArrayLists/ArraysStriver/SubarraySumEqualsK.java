import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3 };
        // int arr[] = { 1, 1, 1 };
        int arr[] = { -1, -1, 1 };
        int limit = 0;
        int n = arr.hashCode();
        // int total = (n * (n + 1)) / 2;

        System.out.println(subArraySumEqualsK(arr, limit));

    }

    public static int subArraySumEqualsK(int arr[], int k) {
        int n = arr.length;
        int prefix = 0;
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // putting zero initially --> denoting no elements in subarray

        for (int i = 0; i < n; i++) {
            prefix += arr[i];
            int remove = prefix - k;
            if (hm.containsKey(remove)) {
                count += hm.get(remove);
            }

            hm.put(prefix, hm.getOrDefault(prefix, 0) + 1);

        }

        return count;

    }

    /**
     * 
     * In this question we implement a better version of the brute force solution
     * 
     * 
     * @param arr
     * @param k
     * @return
     */
    public static int subarraySum(int[] arr, int k) {
        // Size of the array
        int n = arr.length;

        // Initialize count of subarrays
        int count = 0;

        // Traverse all possible start indices
        for (int i = 0; i < n; i++) {
            // Initialize sum for current subarray
            int sum = 0;

            // Traverse all possible end indices from start
            for (int j = i; j < n; j++) {
                // Add current element to sum
                sum += arr[j];

                // If sum equals k, increment count
                if (sum == k) {
                    count++;
                }
            }
        }

        // Return total count of subarrays
        return count;
    }

    /**
     * Implementing the brute force approach for the given question
     * 
     * @param arr
     * @param k
     * @return
     */
    public int subarraySumBruteForce(int[] arr, int k) {
        // Size of the array
        int n = arr.length;

        // Initialize count of subarrays
        int count = 0;

        // Traverse all possible start indices
        for (int i = 0; i < n; i++) {
            // Traverse all possible end indices from start
            for (int j = i; j < n; j++) {
                // Initialize sum for current subarray
                int sum = 0;

                // Calculate sum of subarray from i to j
                for (int m = i; m <= j; m++) {
                    sum += arr[m];
                }

                // If sum equals k, increment count
                if (sum == k) {
                    count++;
                }
            }
        }

        // Return total count of subarrays
        return count;
    }

    /**
     * This method can only be implemented if we have know that the input array only
     * contains of all the positive integers
     * 
     * @param arr
     * @param k
     * @return
     */
    public static int subArraySumLessThanEqualToKPositives(int arr[], int k) {

        int sum = 0;
        int i = 0;
        int j = 0;
        int n = arr.length;
        int total = 0;

        while (j < n) {
            sum += arr[j++];

            while (sum > k && i <= j) {
                sum -= arr[i++];
            }

            total += j - i + 1;

        }

        return total;
    }

}
