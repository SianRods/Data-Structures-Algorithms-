public class Pattern {
    public static void main(String[] args) {
        patternPrint(4, 0);
    }

    static void patternPrint(int rows, int cols) {
        if (rows == 0) {
            return;
        } else {
            for (int i = 0; i < cols; i++) {
                System.out.print("*");
            }
            System.out.println();
            patternPrint(rows - 1, cols - 1);
        }
    }

}
