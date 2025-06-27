
public class ReverseANumber {
    public static void main(String[] args) {
        int num = 1824;
        System.out.println(reverseNumberUsingRecurrsion(num));
    }

    public static int reverseNumberUsingRecurrsion(int num) {
        // if only one digit remains return as it is
        // here we have to formulate a typical base condition which is not that obvious
        if (num % 10 == num) {
            return num;
        } else {
            return (int)(num%10*(int)Math.pow(10, (int)(Math.log10(Math.abs(num))))) + reverseNumberUsingRecurrsion(num/10);
        }
    }

}
