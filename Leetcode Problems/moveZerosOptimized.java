
import java.util.Arrays;

public class moveZerosOptimized {
    public static void main(String[] args) {
        int arr[] = { 0,1,0,3,12 };
        System.out.println(Arrays.toString(shiftZeros(arr)));
    }

    static int[] shiftZeros(int arr[]) {
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0 && arr[i + 1] != 0) {
                // Swapping with it's next element
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            } else if (count > 1) {
                // Swapping the Extremen Ends
                while (i + count < arr.length && arr[i + count] == 0) {
                    count++;
                }
                if (i + count < arr.length) { // Ensure valid index before swapping
                    int temp = arr[i];
                    arr[i] = arr[i + count];
                    arr[i + count] = temp;
                }
            }

        }
        return arr;
    }
}