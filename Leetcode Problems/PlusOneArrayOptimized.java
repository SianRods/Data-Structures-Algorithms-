import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOneArrayOptimized {

    public static void main(String[] args) {
        int arr[] = { 9};
        System.out.println(Arrays.toString(incrementArray(arr)));
    }

    static int[] incrementArray(int arr[]) {
        // Using the list Collection
        boolean status = false;
        // List<Integer> solution = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[arr.length - i - 1] < 9) {
                // If the lsb is less than 9 than increment the digit
                arr[arr.length - i - 1] += 1;
                status = true;
                // BREAKING THE LOOP ONCE WE HAVE SUCCESSFULLY IMPLEMENTED THE INCREMENTATION
                return arr;
            } else if (arr[arr.length - i - 1] == 9) {
                // MAKING THE ELEMENT
                arr[arr.length - 1 - i] = 0;
            }
        }
        // After completing the loop check whether the given array was sufficient for
        // incrementing using the status flag
        if (!status) {
            // We are no unece
            int sol[] = new int[arr.length + 1];
            for (int j = 0; j < sol.length; j++) {
                if (j == 0) {
                    sol[j] = 1;
                    
                } else {
                    sol[j] = 0;
                }
            }
            return sol;

        }
        return new int[] {-1};
    }
}