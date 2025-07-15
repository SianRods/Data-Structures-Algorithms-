public class MinimumTimeForTypewriter {

    public static void main(String[] args) {

    }

    public int minTimeToType(String word) {
        int time = 0;

        char prev = 'a';

        for (int j = 0; j < word.length(); j++) {
            char curr = word.charAt(j);
            int dist = Math.abs(curr - prev);
            dist = Math.min(dist, 26 - dist); // What if Negative ??
            time += dist + 1;
            prev = curr;
        }

        return time;

    }
}
