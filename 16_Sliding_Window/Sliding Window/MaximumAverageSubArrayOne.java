public class MaximumAverageSubArrayOne {
    public static void main(String[] args) {

    }

    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        double sum = 0;

        while (j < k && j < n) {
            sum += nums[j];
            j++;
        }

        double maxAvg = sum / k;
        while (j < n) {
            sum = sum - nums[i] + nums[j];
            if (maxAvg < sum / k) {
                maxAvg = sum / k;

            }
            i++;
            j++;

        }

        return maxAvg;

    }
}
