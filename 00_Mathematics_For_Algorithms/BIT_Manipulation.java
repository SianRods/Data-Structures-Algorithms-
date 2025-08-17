public class BIT_Manipulation {
    public static void main(String[] args) {

    }

    public static String convertToBinary(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }

        return sb.reverse().toString();
    }

    public static int convertToInt(String s) {
        int sol = 0;
        int pow = 1;
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 1) {
                sol += pow;
            }

            pow *= 2;
        }

        return sol;
    }

    public static int onesComplement(int num) {
        // Remember the following returns answer for a signed integer 
        // for unsigned integer we would have to change certain aspects of it 
        return ~num;
    }

    public static int twoComplement(int num) {
        // Adding one to the one's complement of the given number
        return onesComplement(num) + 1;
    }

    // Be aware of the overflow conditions

}

// 1] Introduction to Number theory and Binary to decimal Conversion
// 2] One's Complement and Two's Complement
// 3] Normal Logical Operators
// 4] Shift Operators
// 5] Range of Integers and their size
// 6] Overflow Condition