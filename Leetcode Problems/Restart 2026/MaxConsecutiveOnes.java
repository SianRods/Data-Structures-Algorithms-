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
}
