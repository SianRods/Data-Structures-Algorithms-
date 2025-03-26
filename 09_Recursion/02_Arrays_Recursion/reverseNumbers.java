
public class reverseNumbers {
    public static void main(String[] args) {
        // System.out.println("The reverse of the Number 987654321 is "+reverseNumberPart1(987654321));
        reversePart2(987654321);
        System.out.println("The reverse of the number 987654321 is "+sum);
    }


    static int reverseNumberPart1(int num){
        if(num%10 == num){
            return num;
        }else{
            // Counting the Number of Digits : (int)(Math.log10(Math.abs(num)) +1)
            // This Method can be used to count the number of Digits in O(1) time complexity
            return (num%10*(int)Math.pow(10, (int)(Math.log10(Math.abs(num))))) + reverseNumberPart1(num/10);
        }
    }

    // 1234 --> 4*10 +3 = 43 
    
    // There is one more method in which we can make this work
    // We can actually create a helper function which will keep updating a global variable instead of  making changes to the variable inside function calls 
    static int sum=0;
    // Here the function won't return anything as it is used for updating a global variable 
    static void reversePart2(int num){
        if(num==0){
            return;
        }
        else{
            sum = (sum*10)+(num%10);
            reversePart2(num/10);

        }
    }


    // Checking if the number is palindrome or not ??

    static boolean isPalin(int num){
        return num==reverseNumberPart1(num);
    }

}
