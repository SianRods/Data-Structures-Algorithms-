public class AddDigits {
    public static void main(String[] args) {

    }

    public static int digits(int num) {
        while (num / 10 != 0) {
            int digitSum = 0;
            while (num != 0) {
                digitSum += num % 10;
                num /= 10;
            }
            num = digitSum;
        }

        return num;
    }
}
