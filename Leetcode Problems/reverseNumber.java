// Notice here that we have to also consider the Integer Number with signs
// ex. -1
// -1%10 --> remainder is 9
// We don't have to convert it to 
// If you want to fix your code in a normal way we can do that by ensuring the sign check for each number 

public class reverseNumber {
    public static void main(String args[]) {
        System.out.println(isPalindrome(2147483647));
    }

    static boolean isPalindrome(int num) {
        long reverse = 0;
        int digit;
        int len = countNumber(num);
        int copyNumber = num;
        if (num > 0) {
            do {
                len--;
                digit = num % 10;
                // System.out.println(digit);
                reverse += (digit * Math.pow(10, len));
                // System.out.println(reverse);
                num /= 10;
            } while (num > 0);

            if (copyNumber - reverse == 0) {
                return true;
            } else {
                return false;
                
            }
        } else if(num<0) {
            return false;
        }else{
            return true;
        }

    }

    static int countNumber(int num) {
        int count = 0;

        do {

            num /= 10;
            count++;
        } while (num > 0);
        return count;

    }
}