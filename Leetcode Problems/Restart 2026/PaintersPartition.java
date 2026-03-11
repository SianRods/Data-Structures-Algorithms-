public class PaintersPartition {
    public static void main(String[] args) {

    }

    // exactly similar to that of Book Allocation problem

    /**
     * Consider that each unit of a board takes 1 unit of time to paint.
     * --> Supposed to return the area of the minimum time to get this job done of
     * painting all the ‘N’ boards
     * under the constraint that any painter will only paint the continuous sections
     * of boards.
     * 
     * @param boards representing the length of board ith
     * @param k      number of available painters to paint all the boards
     * @return
     * 
     */
    public static int solution(int boards[], int k) {
        int n = boards.length;

        if (k > n) {
            return -1;
        }
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        // int n = books.length;

        for (int i = 0; i < n; i++) {
            sum += boards[i];
            maxi = Math.max(maxi, boards[i]);
        }

        int low = maxi;
        int high = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int required = noOfPainters(boards, mid);
            if (required <= k) {
                high = mid - 1;
            } else if (required > k) {
                low = mid + 1;
            }

        }
        return low;

    }

    private static int noOfPainters(int[] boards, int maxpages) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < boards.length; i++) {
            if (sum + boards[i] <= maxpages) {
                sum += boards[i];

            } else {
                count++;
                sum = boards[i];
            }

        }

        // here count denotes total number of painters that would be required to paint
        // all the blocks 
        // for a given maximum limit ;
        return count;
    }

}
