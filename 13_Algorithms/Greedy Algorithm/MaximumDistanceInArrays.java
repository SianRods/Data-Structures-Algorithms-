import java.util.List;

public class MaximumDistanceInArrays {
    public static void main(String[] args) {

    }

    public static int maxDistance(List<List<Integer>> arrays) {
        // All the internal Arrays are already sorted
        // We have to select them seperately from two different arrays
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;

        for (int i = 0; i < arrays.size(); i++) {
            int n = arrays.get(i).size();
            int minInternal = arrays.get(i).get(0);
            int maxInternal = arrays.get(i).get(n - 1);

            // option 1 : either we update maximum internally
            result = Math.max(result, Math.abs(maxInternal - min));
            // option 2 : either we update minimum internally
            result = Math.max(result, Math.abs(max - minInternal));

            min = Math.min(minInternal, min);
            max = Math.max(max, maxInternal);

        }

        return result;
    }
}
