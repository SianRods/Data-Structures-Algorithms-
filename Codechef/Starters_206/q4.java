import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class q4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
kf
        while (t-- > 0) {

            int n = sc.nextInt();

            if (n == 2) {
                System.out.println("0 0");
            } else {
                long minEnt = (n - 2);
                long maxEnt = (long) (n - 2) * (n - 1) / 2;
                System.out.println(minEnt + " " + maxEnt);
            }

        }

    }

}