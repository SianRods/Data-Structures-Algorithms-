import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args) {

    }

    public static void solution(int arr[]) {
        int n = arr.length;
        // detect the break point in the array

        int breakPoint = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                breakPoint = i;
                break;
            }

        }

        // if the breakpoint does not exists --> arr in ascending order returns highest
        // permutation for
        // given array
        if (breakPoint == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // else detect the just larger number for the number at the breakpoint

        for (int i = n - 1; i >= breakPoint; i--) {
            if (arr[i] > arr[breakPoint]) {
                swap(arr, breakPoint, i);
                break;
            }

        }

        // now reverse the remaning part and

        reverse(arr, breakPoint + 1, n - 1);

    }

    // Helper to reverse array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Helper to swap
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
