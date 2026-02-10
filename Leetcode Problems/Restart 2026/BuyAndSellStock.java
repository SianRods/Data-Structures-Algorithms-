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
    public static int solution(int arr[]) {
        int n = arr.length;
        int prev = arr[n - 1]; // --> 4
        int maxProfit = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > prev) {
                prev = arr[i];
            } else {
                maxProfit = Math.max(maxProfit, prev - arr[i]);
            }

        }
        return maxProfit;

    }

}
