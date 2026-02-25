public class SingleElementinArray {
    public static void main(String[] args) {
        // int arr[] = { 3, 3, 7, 7, 10, 11, 11 };
        int arr[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(solution(arr));
    }

    public static int solution(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        // Log(n) TC Solution
        while (start < end) {
            int mid = start + (end - start) / 2;

            // force mid to be even --> cause after that we can directly determine how to
            // shift our
            // middle element as per the current
            // even or odd index
            if (mid % 2 == 1) {

                // This acts as a very crucial step in solving the given problem 
                // w.r.t deciding proper edge cases and optimization
                mid--;
            }
            if (arr[mid] == arr[mid + 1]) {

                start = mid + 2;
            } else {

                end = mid;
            }

        }

        return arr[start];

    }

}
