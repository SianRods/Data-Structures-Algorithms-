public class FibonacciSum {
    public static void main(String[] args) {
        System.out.println(sumTillFibonacci(6));
    }
    // In order to identify whther a problem can be solved using recursion or not we
    // have to determine that
    // the given bigger problem can be sovled in smaller steps

    public static int sumTillFibonacci(int term) {
        if (term < 3) {
            return (term - 1);
        }

        return sumTillFibonacci(term - 1) + Fibonth(term);
    }

    static int Fibonth(int n) {
        if (n < 3)
            return n - 1;

        return Fibonth(n - 1) + Fibonth(n - 2);
    }

}
