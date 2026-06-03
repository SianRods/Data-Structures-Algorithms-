public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        int n = arr.length;
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int count = 0;

        while (i < n && j < n) {
            if (arr[j] == 0) {
                count++;
            }

            while (count > k && i < n) {
                if (arr[i] == 0) {
                    count--;
                }
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;

        }
    }

    /**
     * This Function can only be used if the array contains only 0 and 1 in it
     *  
     * 
     * @param arr
     * @return
     */
    public static int countMaxConsecOnes(int arr[]) {
        int maxSum = 0;
        int runSum = 0;

        for (int num : arr) {
            runSum += num;

            if (num == 0) {
                runSum = 0;
            }
            maxSum = Math.max(maxSum, runSum);
        }

        return maxSum;

    }

}
