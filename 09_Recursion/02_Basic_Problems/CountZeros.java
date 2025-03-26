
// Counting the Number of Zeros in a Number 
// 1. Taking the COunt Variable Inside the Function {here we will keep on passing the updated value of count to the post function call }
// 2. Taking a Global Count Variable {Limited Scope}

public class CountZeros {
    public static void main(String[] args) {
        System.out.println("The number of Zeors in 20300400 is " + countNumberZeroInnerVariable(20300400, 0));
    }

    static int countNumberZeroInnerVariable(int num, int countValue) {
        if (num % 10 == num) {
            // If all the digits are evaluated return the countValue Variable
            // Here this thing is the base condition
            if (num == 0) {
                countValue++;
            }
            return countValue;
        } else {
            if (num % 10 == 0) {
                // Here update the value of the count
                return countNumberZeroInnerVariable(num / 10, countValue + 1);
            } 
                // here keep the count value as it is
                return countNumberZeroInnerVariable(num / 10, countValue);
            
        }
    }
}
