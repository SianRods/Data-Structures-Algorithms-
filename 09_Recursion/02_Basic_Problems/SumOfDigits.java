
public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(1234551));
    }

    // Using the same concept of Remainder of the number
    static int sumOfDigits(int num) {
        if (num == 0 ) {
    
            return 0;
        } else {
            return num % 10 + sumOfDigits(num / 10);
        }
    }

}
