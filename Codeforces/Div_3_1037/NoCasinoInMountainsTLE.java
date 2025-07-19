
import java.util.Scanner;

public class NoCasinoInMountainsTLE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            // Taking the input of the arrays ;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int count = 0;
            boolean canHike = false;
            int i = 0;
            
            // In this given problem we start from the ith and jth index check for the valid
            // day and continue
            while (i <= n - k) {
                if (arr[i] == 0) {
                    canHike = true;
                    for (int j = i; j < i + k; j++) {
                        if (arr[j] == 1) {
                            canHike = false;
                            break;
                        }
                    }
                }

                if (canHike) {
                    count++;
                    i += k + 1;
                } else {
                    i++;
                    // Trying hiking on the next possible day;
                }
            }

            System.out.println(count);

        }
    }

}
