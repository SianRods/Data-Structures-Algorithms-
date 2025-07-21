public class DivisiblityBySumAndProduct {
    public static void main(String[] args) {
        System.out.println(checkDivisibility(99));

    }

    public static boolean checkDivisibility(int n) {
        if (n % (sumOfDigits(n) + productOfDigits(n)) == 0)
            return true;
        return false;

    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }

        return sum;
    }

    public static int productOfDigits(int n) {
        int prod = 1;
        while (n != 0) {
            int digit = n % 10;
            prod *= digit;
            n = n / 10;
        }

        return prod;
    }

}