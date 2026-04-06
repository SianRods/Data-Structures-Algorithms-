public class KBeautyOfANumber {
    public static void main(String[] args) {

    }

    public static int divisorSubstrings(int num, int k) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int i = 0;
        int n = sb.length();
        int j = 0;
        int count = 0;
        while (j < n && j < k) {
            j++;
        }

        while (j < n) {
            int subnum = Integer.valueOf(sb.substring(i, j));
            if (subnum != 0 && num % subnum == 0) {
                count++;
            }

            i++;
            j++;
        }

        return count;

    }
}
