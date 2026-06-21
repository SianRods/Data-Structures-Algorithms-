public class ShipPackagesinD {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr[] = { 3, 2, 2, 4, 1, 4 };
        // int days = 5;
        int days = 3;
        System.out.println(minWeightCapacityOfShip(arr, days));

    }

    // capacity to ship the packages within D days
    // by the nature of this question we realize that we can have to apply BS search
    // answer
    // it is also to understand that figuring the range of the search space to be
    // explored is important

    // Just think about the following question --> whats the maximum capacity of the
    // ship that is requried ??
    public static int minWeightCapacityOfShip(int[] weights, int days) {
        int sum = 0;
        int start = 1; // maximum weight of individual package on the ship

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            // Note that here the goal is to ship all the packages with weights w[i]
            // withing d days from one port to another the things is that
            // we can only load packages onto ship with weight<=ship so for all the packages
            // to be delivered
            // the min weight of the ship should be the single maximum weight of the package
            start = Math.max(start, weights[i]);
        }

        int end = sum;

        int ans = 0;

        // need to know whether the bounds will be (start<=end) ?? or (start<end) ??
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // check if the mid works -->
            // maintain a running sum and a counter to keep track of everything
            int cum = 0;
            int count = 1;
            for (int j = 0; j < weights.length; j++) {
                cum += weights[j];
                if (cum > mid) {
                    // increment the count & reset the num
                    count++;
                    cum = weights[j];
                }

                // check if it crosses the min number of days required
                if (count > days) {
                    break;
                }

            }

            // compare the count and the days --> determine the underflow
            if (count <= days) {
                // try lower ship capacity
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return ans;

    }
}
