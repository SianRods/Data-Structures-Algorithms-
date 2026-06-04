public class DutchFlagAlgorithm {
    public static void main(String[] args) {
        int arr[] = { 2, 0, 2, 1, 1, 0 };
    }

    public static int[] countApproach(int arr[]) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                zero++;
            if (arr[i] == 1)
                one++;
            else {
                two++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (zero != 0) {
                arr[i] = 0;
                zero--;

            } else if (one != 0) {
                arr[i] = 1;
                one--;

            } else {
                arr[i] = 2;
                two--;
            }
        }
        return arr;
    }

    /**
     * In this method we divide the array in four distinct parts and then process is
     * part wise one-by-one
     * 
     * @return arr
     * 
     */
    public static int[] dutchFlag(int arr[]) {
        int n = arr.length;
        int low = 0;
        int mid = 0; // --> we start mid from low and expand it gradually
        int high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;

            }

        }

        return arr;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
