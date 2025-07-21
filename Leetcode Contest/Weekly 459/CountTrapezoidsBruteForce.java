import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CountTrapezoidsBruteForce {
    public static void main(String[] args) {
        // int arr[][] = { { 1, 0 }, { 2, 0 }, { 3, 0 }, { 2, 2 }, { 3, 2 } };
        int arr[][] = { { 87, -39 }, { 12, -94 }, { -30, -11 }, { -76, -11 } };
        System.out.println(countTrapezoids(arr));
    }

    public static int countTrapezoids(int[][] points) {
        int n = points.length;
        HashMap<Integer, Integer> hmy = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hmy.put(points[i][1], hmy.getOrDefault(points[i][1], 0) + 1);
        }

        List<Integer> valy = new ArrayList<>(hmy.keySet());

        for (int i = 0; i < valy.size(); i++) {
            int pnt = valy.get(i);
            if (hmy.get(pnt) < 2) {
                hmy.remove(pnt);

            }
        }

        valy = new ArrayList<>(hmy.keySet());
        int arr[] = new int[hmy.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = hmy.get(valy.get(i));
        }

        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int one = arr[i];
                int two = arr[j];

                int b1 = (one * (one - 1)) / 2;
                int b2 = (two * (two - 1)) / 2;

                res += b1 * b2;
            }
        }

        return res;

    }

    public int CountTrapezoidsOptimizedUsingMath(int points[][]) {
        final int MOD = 1_000_000_007;
        final int INV2 = 500_000_004; // modular inverse of 2 mod 1e9+7

        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < n; i++) {
            int y = points[i][1];
            hm.put(y, hm.getOrDefault(y, 0) + 1);

        }

        long sum = 0;
        long sumOfSquares = 0;

        for (Integer val : hm.values()) {
            if (val >= 2) {
                long c = val;
                long nc2 = (c * (c - 1) / 2) % MOD;
                sumOfSquares = (sumOfSquares + (nc2 * nc2) % MOD) % MOD;

            }
        }

        long sumSquared = (sum * sum) % MOD;
        long result = (sumSquared - sumOfSquares + MOD) % MOD;

        result = (result * modInverse(2, MOD)) % MOD;

    }

 

}
