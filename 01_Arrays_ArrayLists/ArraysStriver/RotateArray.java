import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int arr[] = { -1, -100, 3, 99 };
        int k = 2;
        // int k = 3;
        // System.out.println(Arrays.toString(solution1(arr, k)));
        // System.out.println(Arrays.toString(solution2(arr, k)));
        // System.out.println(Arrays.toString(solution3(arr, k)));
        solution3(arr, k);

    }

    /**
     * The following Approach directly uses O(n) time complexity
     * O(N) Space Complexity in order to place the elements at their
     * correct location after rotation
     * 
     * @param nums
     * @param k
     * @return
     */
    public static int[] solution1(int nums[], int k) {

        int n = nums.length;
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[(i + k) % n] = nums[i];

        }
        return arr;

    }

    /**
     * This is the brute force approach in which we just rotate left or right
     * n times each
     * 
     * Time Complexity --> O(n**2)
     * Space Complexity --> O(n)
     * 
     * 
     * @param nums
     * @param k
     * @return
     */
    public static int[] solution2(int nums[], int k) {

        int n = nums.length;
        int temp = 0;

        for (int i = 0; i < k; i++) {
            temp = nums[n - 1];
            for (int j = 1; j < n; j++) {
                temp = nums[j];
                nums[j] = nums[j - 1];

            }

            nums[0] = temp;
        }

        return nums;
    }

    /**
     * 
     * Note that this method takes input as k but when k>n
     * Normalizing k is very important
     * We are simply reversing within a set bounds in order to rotate
     * left or right by k elements
     * 
     * 
     * @param nums input array
     * @param k    number of right rotations to be perfromed
     * @return Rotated Arrays
     */
    public static int[] solution3(int nums[], int k) {
        int n = nums.length;

        // most important part
        k = k % n;

        reverseWithinBounds(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));

        reverseWithinBounds(nums, 0, k - 1);
        System.out.println(Arrays.toString(nums));

        reverseWithinBounds(nums, k, n - 1);
        System.out.println(Arrays.toString(nums));

        return nums;
    }

    /**
     * 
     * @param arr   array to reverse
     * @param start starting bound of the array to reverse [Inclusive]
     * @param end   ending bounds of the array to reverse
     */
    public static void reverseWithinBounds(int arr[], int start, int end) {

        int temp = 0;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }

    }

}
