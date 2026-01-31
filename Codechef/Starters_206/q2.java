import java.util.Arrays;
import java.util.Scanner;

public class q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int cost = 0;
            int i = 0;
            while (k-- > 0) {
                cost += arr[i];
                i++;
            }

            System.out.println(cost);

        }

    }

}