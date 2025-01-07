import java.util.Arrays;
import java.util.Comparator;

public class BuySellStockWrongApproach {
    public static void main(String[] args) {
        int arr[] = {1,2 };
        System.out.println(maxProfit(arr));
    }

    static int maxProfit(int prices[]) {

        // in order to use custom comparator we must have Wrapper class arrays and not
        // of primitive data types
        Integer indices[] = new Integer[prices.length];
        for (int i = 0; i < prices.length; i++) {
            indices[i] = i;
        }

        // Using the Custom Comparator to sort the arrays which is similar to keys which
        // we use in python

        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(prices[i1], prices[i2]);
            }
        });

        if (indices[0] == prices.length - 1) {
            return 0;
        }
        int max =1;
        for (int k = indices[0]+1; k <prices.length - indices[0]; k++) {
            if (prices[k] - prices[indices[0]] > max) {
                max = prices[k] - prices[indices[0]];
            }
        }

        return max;
    }
}
