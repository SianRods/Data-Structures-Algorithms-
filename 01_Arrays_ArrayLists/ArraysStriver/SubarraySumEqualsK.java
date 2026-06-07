import java.util.Hashtable; 

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
        Hashtable<Integer, Integer> hm = new Hashtable<>();
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
