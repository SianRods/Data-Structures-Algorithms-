
public class SortedArray {
    public static void main(String[] args) {

    }

    public static boolean isArraySorted(int arr[]) {
    
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;

    }

}
