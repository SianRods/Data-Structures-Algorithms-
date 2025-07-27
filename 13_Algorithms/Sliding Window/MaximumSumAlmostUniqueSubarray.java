import java.util.HashMap;
import java.util.List;

public class MaximumSumAlmostUniqueSubarray {
    public static void main(String[] args) {
        // int arr[] = { 2, 6, 7, 3, 1, 7 };
        // int m = 3;
        // int k = 4;
        // int arr[] = { 5, 9, 9, 2, 4, 5, 4 };
        // int m = 1;
        // int k = 3;
        int arr[] = { 1, 2, 1, 2, 1, 2, 1 };
        int m = 3;
        int k = 3;
        System.out.println(maxSumHelp(arr, m, k));
    }

    public static long maxSumHelp(List<Integer> nums, int m, int k) {
        int n = nums.size();
        long sum = 0;
        long maxSum = 0;
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (j < n) {
            int c = nums.get(j);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
            sum += c;

            while (i < j && (hm.size() > k || (j - i) + 1 > k)) {
                int ch = nums.get(i);

                hm.put(ch, hm.getOrDefault(ch, 0) - 1);
                if (hm.get(ch) == 0) {
                    hm.remove(ch);
                }
                sum -= ch;

                i++;
            }

            if (j - i + 1 == k && hm.size() >= m) {
                maxSum = Math.max(maxSum, sum);
            }
            j++;
        }

        return maxSum;
    }
}
