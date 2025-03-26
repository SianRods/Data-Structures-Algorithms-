
public class ProductOfDigits {
    public static void main(String[] args) {
        System.out.println("The product of all the digits in 6543321 :"+productDigits(6543321));
    }

    static int productDigits(int num) {
        if (num % 10 == num) {
            // If the single number remains then return the num itself
            return num;
        }
        else{
            return num%10*productDigits(num/10);
        }

    }
}
