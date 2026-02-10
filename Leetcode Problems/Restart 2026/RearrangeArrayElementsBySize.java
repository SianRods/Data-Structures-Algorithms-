import java.util.Arrays;

public class RearrangeArrayElementsBySize {
    public static void main(String[] args) {
        // int arr[] = { 3, 1, -2, -5, 2, -4 };
        // int arr[] = { -1, 1 };
        // int arr[] = { 1, 2, -4, -5 };
        // int arr[] = { 1, 2, 3, -1, -2, -3 };
        int arr[] = { 1, 2, -3, -1, -2, 3 };

        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int arr[]) {
        int n = arr.length;
        int i = 0;
        int pos = 0;
        int neg = 1;
        int sol[] = new int[n];

        for (; i < n; i++) {
            if (arr[i] < 0) {
                sol[neg] = arr[i];
                neg += 2;
            } else {
                sol[pos] = arr[i];
                pos += 2;
            }
        }

        return sol;

    }

}
