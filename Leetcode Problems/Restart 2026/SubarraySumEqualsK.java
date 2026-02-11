public class SubarraySumEqualsK {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3 };
        int arr[]={1,1,1};
        int limit = 2;

        System.out.println(sumLessThanEqual(arr, limit) - sumLessThanEqual(arr, limit - 1));

    }

    public static int sumLessThanEqual(int arr[], int limit) {
        int n = arr.length;
        int sum = 0;
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < n) {
            sum += arr[j];

            while (sum > limit && i <= j) {
                sum -= arr[i];
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;

    }

}
