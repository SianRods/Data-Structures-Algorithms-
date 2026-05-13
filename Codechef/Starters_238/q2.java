package Codechef.Starters_238;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read the number of test cases

        while (t-- > 0) {

            int n = sc.nextInt();
            int x = sc.nextInt();
            int k = sc.nextInt();
            // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0],
            // a[0]));
            TreeMap<Integer, Integer> tmp = new TreeMap<>(Collections.reverseOrder());
            for (int i = 1; i <= n; i++) {
                int score = sc.nextInt();
                tmp.put(score, tmp.getOrDefault(score, 0) + 1);
            }

            int candidates = 0;
            // Loop x times, but stop if the map becomes empty
            for (int i = 1; i <= k && !tmp.isEmpty(); i++) {
                Map.Entry<Integer, Integer> entry = tmp.pollFirstEntry();
                if (entry != null) {
                    candidates += entry.getValue();
                }
            }

            if(candidates>x){
                System.out.println(x);
            }else{

                System.out.println(candidates);
            }


        }
    }

}
