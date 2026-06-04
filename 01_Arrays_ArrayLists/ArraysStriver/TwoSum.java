import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {

    }

    /**
     * Note that in this approach we are required to return the indices of the
     * elements as
     * we which form the pairs for a given sum
     * 
     * Time Complexity -> O(N) --> can be more optimized using the two poinnters
     * approach
     * Space Complexity --> O(N)
     * 
     * @param arr
     * @param target
     * @return
     */
    public static int[] hashMapApproach(int arr[], int target) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        int diff = 0;

        for (int i = 0; i < n; i++) {
            diff = target - arr[i];
            if (hm.containsKey(diff)) {
                return new int[] { hm.get(diff), i };
            }
            hm.put(arr[i], i);
        }

        return new int[] { -1, -1 };

    }


    /**
     * This is the most optimal approach for solving the TwoSum 
     * Also notice complexity of below algorithm is 
     * Time Complexity --> O (NlogN) --> sorting 
     * Space Complexity --> O(N)
     * 
     * i<j ==> in bounds because same element repeating twice in the TwoSum is not allowed
     * 
     * 
     * @param arr
     * @param target
     * @return
     */
    public static int[] twoPointers(int arr[], int target) {
        ArrayList<List<Integer>> li = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            li.add(new ArrayList<>(List.of(arr[i], i)));
        }

        Collections.sort(li, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        int i = 0;
        int j = n - 1;

        while (i < j) {
            int sum = li.get(i).get(0) + li.get(j).get(0);
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[] { li.get(i).get(1), li.get(j).get(1) };

            }

        }

        return new int[] { -1, -1 };
    }

}
