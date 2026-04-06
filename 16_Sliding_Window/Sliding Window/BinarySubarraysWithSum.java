public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 0, 1 };
        // int arr[] = { 0, 0, 0, 0, 0 };
        int k = 2;
        // int k = 0;
        System.out.println(numSubarraysWithSum(arr, k));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int countK = 0;
        int countKONE = 0;
        // Subarrays with exactly SUM = At most K- At most (K-1);

        while (j < n) {
            sum += nums[j];

            while (i <= j && sum > goal) {
                sum -= nums[i];
                i++;
            }

            countK += j - i + 1;
            j++;
        }

        i = 0;
        j = 0;
        sum = 0;

        if (goal > 0) {
            while (j < n) {
                sum += nums[j];

                while (i <= j && sum > (goal - 1)) {
                    sum -= nums[i];
                    i++;
                }

                countKONE += j - i + 1;
                j++;
            }
        } else {
            return countK;
        }

        return countK - countKONE;
    }
}
