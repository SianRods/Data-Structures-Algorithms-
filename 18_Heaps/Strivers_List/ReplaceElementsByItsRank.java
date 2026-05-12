import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ReplaceElementsByItsRank {

    // replacing the elements by it's rank in the array
    public static void main(String[] args) {

    }

    /**
     * 
     * Given an array of N integers, the task is to replace
     * each element of the array by its rank in the array
     * 
     * @param arr
     * @return arr of ranks for their corresponding elements
     */
    public static int[] replaceElementsByRankBruteForce(int arr[]) {
        int n = arr.length;
        int dup[] = new int[n]; // O(n)
        for (int i = 0; i < n; i++) {
            dup[i] = arr[i];

        }

        Arrays.sort(arr); // O(NLogN)
        // not necessary to store the previous rank when
        // can access the same using the array
        HashMap<Integer, Integer> hm = new HashMap<>(); // O(n)

        for (int i = 0; i < n; i++) {
            hm.put(arr[i], i + 1);
        }

        for (int i = 0; i < n; i++) {
            dup[i] = hm.get(dup[i]);

        }

        return dup;

    }

    // Implementing using the concept of TreeMaps

    public static int[] replaceElementsByRank(int arr[]) {
        int n = arr.length;
        TreeMap<Integer, Integer> tmp = new TreeMap<>();

        // treemap internally implements the Red-Black tree
        // and can hence handle efficiently the sorting as well as ranking operations
        for (int x : arr) {
            tmp.put(x, 0);
        }

        int rank = 1;
        // update the keys in the treemap for ranking
        for (Map.Entry<Integer, Integer> entry : tmp.entrySet()) {
            entry.setValue(rank++);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = tmp.get(arr[i]);
        }
        return result;

    }

}
