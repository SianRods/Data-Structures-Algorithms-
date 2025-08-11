
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                b[i] = sc.nextInt();

            for (int i = 0; i < n; i++) {
                if (a[i] != b[i] && i + 1 < n) {
                    a[i] = a[i] ^ a[i + 1];
                }
            }

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");

            }

        }
    }
}
