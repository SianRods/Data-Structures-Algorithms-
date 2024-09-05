//  1. Sep Method to Count Number of Digits 
//  2. Even Method 
// 3. 

public class _03Approach_One {

    public static void main(String args[]) {
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
        // Special Boundary Case in Case when Number ==0
        if(num==0){
            return 1;
        }
        int digit = 0;
        while (num != 0) {
            num = num / 10;
            digit++;
        }
        return digit;
    }

}
