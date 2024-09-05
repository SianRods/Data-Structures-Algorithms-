// In this case Digits won't be counted using While Loop we will use Base of Number's Log to count digits

public class _03Optimised_Log {
    public static void main(String args[]){
        int[] nums = { 555, 901, 482, 1771, 34, 3454, 5465, -1234, 00 };
        System.out.println(totalEvenDigitsNumber(nums));
        System.out.println("Number of Digits in 0 is :"+numberOfDigits(0));
    }

    static int totalEvenDigitsNumber(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isEven(numberOfDigits(arr[i]))) {
                count++;
            }
        }
        return count;
    }

    static boolean isEven(int digit) {
        // if (digit % 2 == 0) {
        //     return true;
        // } else {
        //     return false;
        // }
        return  digit%2==0;
    }

    static int numberOfDigits(int num) {
        // Condition if the number is  zero
        if(num==0){
            return 1;
        }

        // If number if Negative 
        if(num<0){
            num *= -1;
        }
// Don't ConfuseSyntax of Java with Python
        return (int)Math.log10((double)num)+1;
    }
    
}
