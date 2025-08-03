public class SeparateBlackAndWhite {
    public static void main(String[] args) {

    }

    public static long minimumSteps(String s) {

        int j = 0;
        int n = s.length();
        int cnt = 0;
        long mvs = 0;
        while (j < n) {

            if (s.charAt(j) == '1') {
                cnt++;
            }

            else {
                mvs += cnt;
            }
            j++;
        }

        return mvs;
    }
}
