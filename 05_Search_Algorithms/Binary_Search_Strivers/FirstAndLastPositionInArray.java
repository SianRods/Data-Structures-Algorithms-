public class FirstAndLastPositionInArray {
    public static void main(String[] args) {
        int arr[] = { 5, 7, 7, 8, 8, 10 };
        int target = 10;
        int sol[] = new int[2];
        sol[1] = upperBound(arr, target);
        sol[0] = lowerBound(arr, target);
        System.out.println("The Bounds for the given element" + target + "are {" + sol[0] + "," + sol[1] + "}");
    }

    public static int upperBound(int arr[], int x) {
        int start = 0;
        int end = arr.length - 1;

        if (end < 0)
            return -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] <= x) {

                start = mid + 1;
            } else if (arr[mid] > x) {
                end = mid - 1;
            }

        }
        if (end >= 0 && arr[end] == x)
            return end;
        return -1;

    }

    public static int lowerBound(int arr[], int x) {
        int start = 0;
        int end = arr.length - 1;
        if (end < 0)
            return -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] < x) {

                start = mid + 1;
            } else if (arr[mid] >= x) {
                end = mid - 1;
            }

        }

        if (start < arr.length && arr[start] == x)
            return start;
        return -1;

    }
}
