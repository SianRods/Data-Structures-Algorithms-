
public class BestTimeToBuyAndSell {
    public static long maxProfit(int[] prices, int[] strategy, int k) {
        int n = strategy.length;

        long intialProfit = 0;
        for (int i = 0; i < n; i++) {
            intialProfit += (long) prices[i] * strategy[i];
        }

        long maxChange = 0;

        for (int start = 0; start + k <= n; start++) {

            long change = 0;

            for (int i = start; i < start + k / 2; i++) {
                change -= (long) prices[i] * strategy[i];
            }

            for (int i = start + k / 2; i < start + k; i++) {
                change += (long) prices[i] * (1 - strategy[i]);
            }

            maxChange = Math.max(maxChange, change);
        }

        // Here it is the initial profit + the maximum possible change that can be
        // acehieved by perform the given operations

        return maxChange + intialProfit;
    }

}
