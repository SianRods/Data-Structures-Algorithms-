public class BSRecursion {
    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(recursiveBS(arr, 0, arr.length, 7));

    }

    static int recursiveBS(int arr[], int start, int end, int target) {
        int middle = start + (end - start) / 2;
        if (start > end) {
            return -1;

        } else {
            if (arr[middle] == target) {
                return 1;
            } else if (arr[middle] > target) {
                return recursiveBS(arr, start, middle - 1, target);
            } else {
                return recursiveBS(arr, middle + 1, end, target);
            }
        }

    }

}
