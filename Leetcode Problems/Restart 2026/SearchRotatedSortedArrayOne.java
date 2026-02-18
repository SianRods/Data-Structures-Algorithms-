public class SearchRotatedSortedArrayOne {
    public static void main(String[] args) {
        // int arr[] = {4,5,6,7,0,1,2};
        int arr[] = { 3, 1 };
        int target = 3;
        System.out.println(solution1(arr, target));
    }

    /**
     * Although this uses the brute force approach of dividing the array into two
     * parts
     * It does not satisfy the time constrain requirements of problem --> O(Logn)
     * 
     * This solution yeilds a O(n) time complexity due to search of the pivot index
     * 
     * @param arr    sorted array
     * @param target target element to be searched
     * @return returning the position of the target element
     * 
     */
    public static int solution1(int arr[], int target) {
        int k = findRotatedIndex(arr);
        int n = arr.length;
        System.out.println("The pivot index is " + k);
        if (target >= arr[k] && target <= arr[n - 1]) {
            // search in the second half of the array --> the rotated part
            return binarySearchBounds(arr, target, k, n - 1);
        } else if (k > 0 && arr[0] <= target) {
            return binarySearchBounds(arr, target, 0, k - 1);

        } else {
            return binarySearchBounds(arr, target, 0, n - 1);
        }

    }

    // here as per the given question we are assuming that all the ements in
    public static int findRotatedIndex(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                return i;
            }

        }

        // else if not rotated return 0
        return 0;

    }

    public static int binarySearchBounds(int arr[], int x, int s, int e) {
        int start = s;
        int end = e;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {

                start = mid + 1;
            } else if (arr[mid] >= x) {
                end = mid - 1;
            }

        }

        return -1;
    }

    // [3,4,5,6,0,1,2] sampel array with target=0
    public static int solution2(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                if (arr[start] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                
                }else{
                        
                }

                }
            }
        }

}

}
