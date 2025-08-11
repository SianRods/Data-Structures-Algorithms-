package Rated_800;
import java.util.Scanner;

public class Watermelon4A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        // Except for 2 because 2 cannot be divided into two even parts
        if (w % 2 == 0 && w > 2) {
            System.out.print("YES");

        } else {
            System.out.print("NO");
        }

    }
}
