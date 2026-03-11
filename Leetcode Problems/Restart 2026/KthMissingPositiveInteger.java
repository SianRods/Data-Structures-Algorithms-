public class KthMissingPositiveInteger {
    public static void main(String[] args) {
        // int arr[] = { 2, 3, 4, 7, 11 };
        // int k = 5;
        int arr[] = { 1, 2, 3, 4 };
        int k = 2;
        System.out.println(solution2(arr, k));
    }

    // Here we need to return the kth missing positive integer
    // run a loop till we find the kth missing positive integer
    public static int solution1(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        int num = 0;
        int j = 0;
        int i = 1;
        while (count != k) {
            if (j < n) {
                // within the limits of the input array
                if (i != arr[j]) {
                    count++;
                    num = i;// save the kth positive number

                } else {
                    j++;
                }

            } else {
                count++;
                num = i;

            }

            i++;

        }

        return num;
    }

    // for each of the middle element in the array check how many elements are
    // missing before
    // arr[i]-i-1 ==> denotes number of missing elements before arr[i]
    // and after it and based on comparison move the middle element index
    // Reducing the time to iterate throught the search space
    public static int solution2(int arr[], int k) {
        int n = arr.length;
        // check if the missing element is beyond the maximum of the given input array
        if (k > arr[n - 1] - (n - 1) - 1) {

            return k + (n - 1) + 1;
        }

        // else apply the binary search withing the array bounds

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // depending upon the number of missing elements till the mid shift the pointers
            if (k > arr[mid] - mid - 1) {
                // shift the start pointers
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        // now once the main element is found apply seach between the start and the end
        // pointers
        // assuming the end (start ) and start (end);

        return k + (start - 1) + 1;

    }

}
