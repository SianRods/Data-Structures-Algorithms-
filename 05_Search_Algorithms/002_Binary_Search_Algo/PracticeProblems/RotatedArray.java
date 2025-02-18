public class RotatedArray {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(searchTarget(arr, 0));

    }

    static int[] getPivotPoint(int arr[], int target) {
        int pivot = 0;
        int start = 0;
        int end = arr.length - 1;
        int middle = start + (end - start) / 2;
        if(arr.length==1){
            return new int[] {0,0};
        }
        while (start < end) {

            // Updating the middle value for Binary search 
            if (arr[middle] > arr[middle + 1]) {
                end = middle;
                middle = start + (end - start) / 2;
            } else {
                start = middle + 1;
                middle = start + (end - start) / 2;
            }
        }


        pivot = start;

        // Restting the variable to their original values as they have been updated earlier for purpose of finding the pivot
        start=0;
        end = arr.length - 1;
        if (target <= arr[end]) {
            start = pivot;
        } else if (target <= arr[pivot]) {
            end = pivot;
        }

        return new int[] { start, end };

    }

    static int searchTarget(int arr[], int target) {
        int bounds[] = getPivotPoint(arr, target);
        int start = bounds[0];
        int end = bounds[1];
        int middle = start + (end - start) / 2;

        while (start < end) {
            if (target > arr[middle]) {
                start = middle + 1;
                middle = start + (end - start) / 2;

            } else if (target < arr[middle]) {
                end = middle - 1;
                middle = start + (end - start) / 2;

            } else if (arr[middle] == target) {
                return middle;
            }
        }

        return -1;
    }
}
