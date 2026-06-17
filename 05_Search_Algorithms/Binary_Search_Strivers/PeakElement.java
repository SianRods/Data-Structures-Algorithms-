public class PeakElement {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        System.out.println(getPeak(arr));
    }

    public static int getPeak(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        // do consider the edge cases of start and end while solving this question
        // it is very important to realize the fact that we have to only do local
        // analysis
        // i.e w.r.t mid element

        // Understanding the mentioned constraint of arr[i]!=arr[i+1] is very important
        // in applying this
        // concept properly
        while (start < end) {
            int mid = start + (end - start) / 2;

            // Compare only with right neighbor (safe because start < end)
            if (arr[mid] > arr[mid + 1]) {
                // decreasing slope the peak must be on the left
                end = mid;
            } else {
                // Increasing slope → peak must be on right
                start = mid + 1;
            }

        }

        // or return end both are the same thing
        return start;
    }
}
