import java.util.Arrays;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 9, 3 };
        int k = -2;

        System.out.println(Arrays.toString(decrypt(arr, k)));
    }

    public static int[] decrypt(int[] code, int k) {
        int i = 0;
        int j = 0;
        int n = code.length;
        int sol[] = new int[n];
        if (k > 0) {
            while (i < n) {
                j = i;
                int sum = 0;
                for (int m = k; m > 0; m--) {

                    j++;
                    sum += code[j % n];
                }

                sol[i] = sum;
                i++;

            }
        }

        else if (k < 0) {
            while (i < n) {
                int sum = 0;
                for (int m = 1; m <= -k; m++) {
                    sum += code[(i - m + n) % n];
                }

                sol[i] = sum;
                i++;
            }

        } else {
            while (i < n) {
                sol[i] = 0;
                i++;
            }
        }

        return sol;

    }
}
