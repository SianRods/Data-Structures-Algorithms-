import java.util.Arrays;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 9, 3 };
        int k = -2;

        System.out.println(Arrays.toString(decrypt(arr, k)));
    }

    public static int[] decryptBruteForce(int[] code, int k) {
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

    public static int[] decrypt(int[] code, int k) {
            int n = code.length;
            int sol[] = new int[n];
            int sum = 0;
            int j = 1;
            for (int i = 0; i < n; i++) {
                if (k > 0) {
                    if (sum == 0 && i == 0) {
                        while (j <= k) {
                            sum += code[j % n];
                            j++;
                        }
                        sol[i] = sum;
                    } else {

                        sum -= code[(i + 1) % n];
                        sum += code[j % n];
                         sol[i] = sum;
                        j++;
                    }

                }

                if (k < 0) {
                    if (sum == 0 && i == 0) {
                        while (j <= -k) {
                            sum += code[(i - j + n) % n];
                            j++;
                        }
                        sol[i] = sum;
                    } else {
                        sum -= code[(i - (j - 1) + n) % n];
                        sum += code[(i - j + n) % n];
                         sol[i] = sum;
                        j++;
                    }
                }

                if (k == 0) {
                    return sol;
                }
            }
            return sol;

    }

}
