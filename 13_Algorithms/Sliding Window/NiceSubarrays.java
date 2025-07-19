public class NiceSubarrays {

    public static void main(String[] args) {

    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        int n = nums.length;
        int total = 0;
        while (j < n) {
            while (j < n && count < k) {
                if (nums[j] % 2 != 0)
                    count++;
                j++;
            }
            total += (n - 1) - j;

            while (i <= j && count>k) {
                if(nums[i]%2!=0)count--;
                i++;
                total++;
            }
            while (j < n && (count - 1) != k) {
                j++;
                if (nums[j] % 2 != 0)
                    count++;
                total++;
            }
            i++;

        }

    }

}