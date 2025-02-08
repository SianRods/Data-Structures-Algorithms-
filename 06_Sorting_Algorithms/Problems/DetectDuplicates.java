public class DetectDuplicates {

    public static void main(String[] args) {
        // Outputs for odd number of elements
        // int arr[] = { 0,0,1,2,4,5,5 };
        int arr[] = { 0 };
        System.out.println(containsDuplicate(arr));
    }

    static boolean containsDuplicate(int[] arr) {
        return sortArray(arr);

    }

    static boolean sortArray(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                // Sorting in an ascending order
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
            if (i >= 1) {
                // Comparing the last most sorted elements in the array
                if (arr[arr.length - (i + 1)] == arr[arr.length - (i)]) {
                    return true;
                }
            }

        }
        return false;
    }
}


// Time Limit EXCEED PROBLEM ON TEST CASE WHICH IS TOO LARGE