import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] solution1(int arr[], int target) {

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

  

}
