public class BuyAndSellStock {
    public static void main(String[] args) {
        // int arr[] = { 7, 1, 5, 3, 6, 4 };
        int arr[] = { 7, 6, 4, 3, 1 };
        System.out.println(solution(arr));

    }

    /**
     * 
     * @param arr input array
     * @return Return the maximum profit you can achieve from this transaction.
     *         If you cannot achieve any profit, return 0.
     */
    public static int solution(int prices[]) {
        int maxFuture = 0;
        int n = prices.length;
        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {

            profit = Math.max(profit, maxFuture - prices[i]);
            maxFuture = Math.max(maxFuture, prices[i]);
        }

        return profit;

    }

}
