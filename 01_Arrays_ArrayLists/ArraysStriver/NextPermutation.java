public class NextPermutation {
    public static void main(String[] args) {

        int arr[] = { 1, 3, 5, 4, 2 };
    }

    /**
     * Very non intuitive solution [Start from the end of the array]
     * 1. Finding the Breakpoint
     * 2. Swapping the breakpoint with next largest element
     * 3. reversing the right array of the breakpoint
     * 
     * 
     * @param arr
     * @return
     */
    public static int[] nextPermutation(int arr[]) {
        int breakpoint = -1;
        int n = arr.length;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                breakpoint = i;
                break;
            }
        }

        if (breakpoint < 0) {
            // no next larger combination is possible
            reverseArray(arr, 0, n - 1);
            return arr;
        }

        int greaterBreakpoint = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > arr[breakpoint]) {
                greaterBreakpoint = i;
                break;
            }
        }

        // swap the breakpoint with the position where just greater element that the
        // breakpoint exists
        // and the next greater element of the breakpoint exists
        swap(arr, breakpoint, greaterBreakpoint);

        // reversing the right side part of the beakpoint
        reverseArray(arr, breakpoint+1, n - 1);

        return arr;

    }

    public static void reverseArray(int arr[], int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
