package Rated_800;
import java.util.Scanner;

public class BitLand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = 0;
        while (n-- > 0) {
            String s = sc.next();
            int k = s.length();
            if (s.charAt(0) == '+' || s.charAt(k - 1) == '+') {
                val++;
            } else {
                val--;
            }
        }
        System.out.println(val);
    }
}
