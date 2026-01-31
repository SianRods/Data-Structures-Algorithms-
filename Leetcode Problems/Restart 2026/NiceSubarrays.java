public class NiceSubarrays {
    public static void main(String[] args) {

    }

    public static int subArraysAtMostKOdd(int nums[], int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int count = 0;
        int oddCount = 0;

        while (j < n) {
            if ((nums[j] & 1) == 1) {
                oddCount++;
            }

            // handling the violation condition
            while (oddCount > k && i <= j) {
                if ((nums[i++] & 1) == 1) {
                    oddCount--;
                }
            }

            count += (j - i) + 1;
            j++;
        }
        return count;

    }
}
