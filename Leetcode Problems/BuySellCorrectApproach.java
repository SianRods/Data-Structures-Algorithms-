public class BuySellCorrectApproach {
    public static void main(String[] args) {

    }

    static int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0; // No profit can be made with less than 2 prices
        }

        int minPrice = Integer.MAX_VALUE; // Track the minimum price so far
        int maxProfit = 0; // Track the maximum profit so far

        for (int price : prices) {
            // Update the minimum price if the current price is lower
            if (price < minPrice) {
                minPrice = price;
            } else {
                // Calculate profit if sold at current price and update maxProfit
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}
