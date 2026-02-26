
public class KokoBanana {
    public static void main(String[] args) {
        int arr[] = { 30, 11, 23, 4, 20 };
        int h = 6;
        System.out.println(solution(arr, h));
    }

    /**
     * 
     * There are n piles of bananas,
     * the ith pile has piles[i] bananas.
     * The guards have gone and will come back in h hours.
     * Here the basic idea is to keep on trying different value of k from k = 1 -->
     * n
     * till we are actually able to eat all the bananas in a given time frame
     * NOTE THAT no hours required per pile = CEIL(PILE/K)
     * 
     * @param piles
     * @param h
     * @return The minimum integer k such that she can eat all the bananas within h
     *         hours.
     * 
     */
    public static int solution(int piles[], int h) {
        // We can optimze this question by using a two step approach
        // 1. The only way of minimizing the value of k is by sequentially try the value
        // of k
        // within the range of different values of k
        // 2. Most important thing is figuring out what can be the maximum value of k
        // and that can be figured out by using the simplem concept what's the fastest k
        // for which
        // koko can finish his banana's is the largest pile in the entire pile array

        int kMax = -1;
        for (Integer ele : piles) {
            kMax = Math.max(kMax, ele);
        }
        // k goes from [1,kMax];
        // for each pile compute ceil(pile[i]/k_j) --> choosen k for the jth iteration
        int start = 1;
        int end = kMax;

        while (start < end) {
            int k_j = start + (end - start) / 2;
            int totalHours = 0;
            for (int i = 0; i < piles.length; i++) {
                totalHours += Math.ceilDiv(piles[i], k_j);
                if (totalHours > h) {
                    // stop early if the total number of hours exceeds the time required for the
                    // guards to return
                    break;
                }

            }
            if (totalHours <= h) {
                // It is very very important to understand why can't we actually skip
                // k_j --> k_j can be the answer itself and hence
                // end != k_j-1 and is end = k_j;
                end = k_j;
            } else {
                start = k_j + 1;
            }

        }

        return start;
    }

}
