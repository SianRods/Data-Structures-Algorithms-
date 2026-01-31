public class BinarySubArrayWithSums {

    /*
     * Only real chronology to be understood is that -->
     * People with weight --> 70kgs = (AllWeights<=70 - AllWeights<=69)
     */

    public static void main(String[] args) {
        int nums[] = { 1, 0, 1, 0, 1 };
        int goal = 2;
        int i = 0;
        int j = 0;
        int n = nums.length;
        int sum = 0;
        int count = 0;

        while (i < n && j < n) {
            sum += nums[j];
            if (sum == goal) {
                count++;
            }

            j++;
        }
        // hnalding the violation of the required condition
        while ((sum >= goal || nums[i] == 0) && i <= j) {
            sum -= nums[i++];
            if (sum == goal) {
                count++;
            }
        }
        // return count;

    }

    public static int sumAtMostK(int nums[], int k) {

        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;

        while (j < n) {

            sum+=nums[j];
            while (sum > k && i <= j) {
                sum -= nums[i++];
            }
            count += (j - i) + 1;
            j++;

        }

        return count;

    }

}
