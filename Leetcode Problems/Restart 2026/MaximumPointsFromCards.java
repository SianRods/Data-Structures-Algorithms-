public class MaximumPointsFromCards {
    public static void main(String[] args) {
        // This problem invovles simple math where we are require to perform
        // the permutations and combinations of different elements
        // and find the maximum possible sum among those elements
        // these simple permutations can be done smartly using leftsum and rightsum
        // first calculating left sum till k elements and then adding one single elemnt
        // from
        // the rightmost side
        int leftsum = 0;
        int rightsum = 0;
        int maxsum = 0;
        int cardPoints[] = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 2;

        int i = 0;

        for (; i < k; i++) {
            leftsum += cardPoints[i];
        }

        maxsum = leftsum;

        int j = cardPoints.length - 1;
        for (i = k - 1; i >= 0; i--) {
            leftsum -= cardPoints[i];
            rightsum += cardPoints[j--];
            maxsum = Math.max(maxsum, leftsum + rightsum);

        }

        // return maxsum;

    }

}