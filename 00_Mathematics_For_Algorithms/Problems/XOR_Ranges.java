package Problems;

public class XOR_Ranges {
    // Finding the XOR of numbers in a range from (1--> N) in constant time
    // Pattern is that we will create a batch size of 4
    // A] n%4==1 ==> 1
    // B] n%4==2 ==> n+1
    // C] n%4==3 ==> 0
    // D] n%4==0 ==> n

    public static int xorOneToN(int n) {
        if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else if (n % 4 == 3) {
            return 0;
        } else {
            return n;
        }
    }

    public static int xorLToR(int left, int right) {
        // XOR of all the numbers between a specified bounds
        return xorOneToN(left) ^ xorOneToN(right);

    }

}
