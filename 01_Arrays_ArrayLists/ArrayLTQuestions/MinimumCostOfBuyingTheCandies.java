
import java.util.Arrays;

public class MinimumCostOfBuyingTheCandies {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 3, 3 };
        System.out.println(minimumCost(arr));
    }

    public static int minimumCost(int[] cost) {
        int sol = 0;
        Arrays.sort(cost);
        if (cost.length >= 2) {
            int i = cost.length - 1;

            while (i > 0) {
                sol += cost[i - 1] + cost[i];
                i = i - 3;
            }

            while (i >= 0) {
                sol += cost[i];
                i--;
            }

            return sol;
        } else {
            int i = 0;
            while (i < cost.length) {
                sol += cost[i];
                i++;
            }
            return sol;
        }
    }
}
