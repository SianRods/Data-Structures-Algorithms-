package Rated_800;
import java.util.Scanner;

public class WayTooLongWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            String word = sc.next();
            int k = word.length();
            if (k > 10) {
                String outPut = word.charAt(0) + Integer.toString(k - 2) + word.charAt(k - 1);
                System.out.println(outPut);
            } else {
                System.out.println(word);
            }

        }
    }
}