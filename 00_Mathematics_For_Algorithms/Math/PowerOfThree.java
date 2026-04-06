public class PowerOfThree {
    public static void main(String[] args) {

    }

    public static boolean isPowerOfThree(int n) {
        double object = Math.log10((double) n) / Math.log10((double) 3);
        return (double) (int) object == object;
    }
}
