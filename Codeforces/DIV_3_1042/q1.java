
import java.util.ArrayList;

import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            List<Integer> ia = new ArrayList<>();
            // List<Integer> ib = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (a[i] > b[i]) {
                    ia.add(i);

                }
                // else if (b[i] > a[i]) {
                // ib.add(i);

                // }
            }

            Random rand = new Random();

            int lever = 0;

            while (true) {
                boolean skip = false;

                if (!ia.isEmpty()) {

                    int mapIndexA = rand.nextInt(ia.size());
                    int indexA = ia.get(mapIndexA);
                    a[indexA]--;
                    if (a[indexA] == b[indexA])
                        ia.remove(mapIndexA);
                } else {
                    skip = true;
                }
                // if (!ib.isEmpty()) {
                // int mapIndexB = rand.nextInt(ib.size());
                // int indexB = ia.get(mapIndexB);
                // a[indexB]++;
                // if (a[indexB] == b[indexB])
                // ib.remove(mapIndexB);

                // }

                lever++;

                if (skip)
                    break;

            }

            System.out.println(lever);

        }
    }
}
