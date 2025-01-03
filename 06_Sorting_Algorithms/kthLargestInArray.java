import java.util.Arrays;

public class kthLargestInArray {
    public static void main(String[] args) {
        int arr[] = {3,2,1,5,6,4};
        findkthLargest(arr, 1);
        System.out.println(Arrays.toString(arr));
    }

    static void findkthLargest(int arr[], int k) {
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }

        }
        // return arr[k];
    }
}