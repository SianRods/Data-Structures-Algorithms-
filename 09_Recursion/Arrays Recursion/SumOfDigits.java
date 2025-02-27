
public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(123455));
    }

    // Using the same concept of Remainder of the number
    static int sumOfDigits(int num) {
        if (num % 10 == num) {
            // If the single number remains then return the num itself
            return num;
        } else {
            return num % 10 + sumOfDigits(num / 10);
        }
    }

}
