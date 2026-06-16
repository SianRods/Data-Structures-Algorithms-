
public class FloorAndCeil {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 4, 7, 8, 10 };
        int x = 10;
        int ce = ceil(arr, x);
        int floor = floor(arr, x);
        System.out.println("The floor and Ceil of given numbers are " + floor + "," + ce);
    }

    public static int ceil(int arr[], int x) {
        // similar concept to that of lower bound of a given array
        // here the only difference is that we have to return the value here

        // Smallest Element >=target element
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return arr[start];
    }

    public static int floor(int arr[], int x) {

        // Largest Element <= target element
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return arr[end];
    }

}
