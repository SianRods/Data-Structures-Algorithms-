package Rated_800;
import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sol = 0;
        while (n-- > 0) {
            int count = 0;
            for (int i = 0; i < 3; i++) {
                int in = sc.nextInt();
                if (in == 1)
                    count++;
            }
            if (count >= 2)
                sol++;

        }

        System.out.println(sol);
    }
}
