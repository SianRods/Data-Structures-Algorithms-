import java.util.HashMap;
import java.util.Map;

public class SubarraysWithGivenXOR {
    public static void main(String[] args) {
        // int arr[] = { 4, 2, 2, 6, 4 };
        // int k = 6;
        int arr[] = { 5, 6, 7, 8, 9 };
        int k = 5;
        System.out.println("The SubarraysWithGivenXOR are :" + solution(arr, k));
    }

    public static int solution(int arr[], int k) {
        // List<List<Integer>> sol = new ArrayList<>();

        Map<Integer, Integer> mp = new HashMap<>();

        int prefix = 0;
        int count = 0;

        // add an empty 0
        mp.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            prefix ^= arr[i];
            if (mp.containsKey(prefix ^ k)) {
                // store the subarray in the solution list
                // sol.add(new ArrayList<>(arr))
                // in case if the multiple prefix sums are equal
                count += mp.get(k ^ prefix);
            }

            mp.put(prefix, mp.getOrDefault(prefix, 0) + 1);

        }

        return count;

    }
}
