public class FindPeakElement {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 1, 3, 5, 6, 4 };
        int arr[] = { 1, 2, 3, 1 };
        System.out.println(solution(arr));
    }

    // we are assuming that there will defo be a solution
    // where the peak element exists
    public static int solution(int arr[]) {
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
            if (arr[mid] < arr[mid + 1]) {
                // Increasing slope → peak must be on right
                start = mid + 1;
            } else {
                // Decreasing slope → peak is on left (including mid)
                end = mid;
            }
        }
        
        return start; // or end (both are same here)

    }
}
