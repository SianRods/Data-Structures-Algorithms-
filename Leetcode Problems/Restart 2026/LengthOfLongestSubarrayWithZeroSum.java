import java.util.HashMap;

public class LengthOfLongestSubarrayWithZeroSum {
    public static void main(String[] args) {
        // int arr[] = { 9, -3, 3, -1, 6, -5 };
        int arr[] = { 6, -2, 2, -8, 1, 7, 4, -10 };
        System.out.println(solution1(arr));

    }

    public static int solution1(int arr[]) {
        // very apparent from the nature of the question that in some way we have to
        // make use of the prefix sum concept

        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            // hm.put(sum, i);
            // performing zero check is also very very important
            if (sum == 0) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if (hm.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }

        }

        return maxLength;
    }

}
