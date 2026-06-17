public class MinimumDaysForBouquets {
    public static void main(String[] args) {
        int arr[] = { 7, 7, 7, 7, 12, 7, 7 };
        int m = 2;
        int k = 3;

        System.out.println(solution(arr, m, k));
    }

    public static int solution(int arr[], int m, int k) {
        long required = (long) m * k;

        if (required > arr.length)
            return -1;
        int kmax = Integer.MIN_VALUE;
        int kmin = Integer.MAX_VALUE; // --> Storing the maximum value
        // Tracking the maximum number of days in the given input array
        for (int i = 0; i < arr.length; i++) {
            kmax = Math.max(kmax, arr[i]);
            kmin = Math.min(kmin, arr[i]);
        }

        // select a given day and then try to decide whether it can create --> m
        // bouquets or not
        // if it can create m bouquets the --> try reducing the number of days
        // Using the two pointer approach check whether the given number is possible or
        // not
        int low = kmin;
        int high = kmax;
        int answer = 0;
        while (low <= high) {
            int mid = high + (low - high) / 2;

            // Check whether the given number of days for blooming
            // are necessary for formation of m bouquets
            if (checkDays(arr, mid, m, k)) {
                // store the answer and keep searching for the lower bound answer again and
                // again
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return answer;

    }

    public static boolean checkDays(int arr[], int mid, int m, int k) {
        // function to check whther this number of days are suffiecient for the
        // formation of
        // m bouquets
        int count = 0;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            // check whether
            if (arr[i] <= mid) {
                // count the flower first
                count++;
                // check whether it matches the required frequency of flowers
                if (count == k) {
                    count = 0;
                    result++;
                }
            } else {
                // consider the consequetive once
                count = 0; // --> make the count zero for taking into account the non consecutive flowers
            }

        }

        // check if we have satisfied the number of bouquets criteria

        return result >= m;

    }
}
