public class TimesArrayRotated {

    public static void main(String[] args) {
        // int arr[]={4,5,6,7,0,1,2,3};
        int arr[] = { 3, 4, 5, 1, 2 };
        System.out.println(pivotElement(arr));
    }

    /**
     * First of all check the exact deifinition of the rotation being used in the
     * given question and then accordingly figure out which formula to use 
     * 
     * 
     * @param arr
     * @return
     */
    public static int pivotElement(int arr[]) {

        int start = 0;
        int end = arr.length - 1;
        int n = arr.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // only two of the possible things can happen w.r.t the middle position
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return  mid + 1;
            } else if (mid > start && arr[mid - 1] > arr[mid]) {
                return  mid;
            } else if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            }

        }

        return 0;

    }
}
