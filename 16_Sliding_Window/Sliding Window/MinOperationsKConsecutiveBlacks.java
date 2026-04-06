public class MinOperationsKConsecutiveBlacks {
    public static void main(String[] args) {
        String s = "WBBWWBBWBW";
        int k = 7;

        // String s = "WBWBBBW";
        // int k = 2;

        System.out.println(minimumRecolors(s, k));

    }

    public static int minimumRecolors(String blocks, int k) {
        int i = 0;
        int j = 0;
        int n = blocks.length();
        int countWhite = 0;
        int minOps = 0;

        // Initialize the starting window
        while (j < n && j < k) {
            if (blocks.charAt(j) == 'W')
                countWhite++;
            j++;
        }

        minOps = countWhite;
        while (j < n) {
            if (blocks.charAt(j) == 'W')
                countWhite++;

            if (blocks.charAt(i) == 'W')
                countWhite--;
            if (j - i == k) {
                minOps = Math.min(countWhite, minOps);
            }

            i++;
            j++;

        }

        return minOps;
    }
}
