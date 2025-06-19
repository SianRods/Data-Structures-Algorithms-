public class PartitionArrayThreePartsWithEqualSum {

    public static void main(String[] args) {
        int arr[] = { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 };
        // int arr[] = { 3, 3, 6, 5, -2, 2, 5, 1, -9, 4 };
        System.out.println(canThreePartsEqualSum(arr));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        // Using a greedy apporach by summing up the entire array and then trying to
        // manipulate the same thing
        int n = arr.length;
        boolean result = false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (sum % 3 != 0) {
            return false;
        }

        int sumPart = sum / 3;
        sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == sumPart) {
                count++;
                sum = 0;
            }
        }

        // Return true if and only if there are atleast three partitionis
        return count>=3;

    }
}
