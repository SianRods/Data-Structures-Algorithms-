public class Tricks {
    public static void main(String[] args) {

    }

    public static int[] swapNumbers(int n1, int n2) {
        n1 = n1 ^ n2;
        n2 = n1 ^ n2;
        n1 = n1 ^ n2;

        return new int[] { n1, n2 };
    }

    public static int setBit(int bitIndex, int num) {
        return num | (1 << bitIndex);
    }

    public static int clearBit(int bitIndex, int num) {
        return (num & (~(1 << bitIndex)));
    }

    public static boolean checkBitSet(int bitIndex, int num) {
        return (num & (1 << bitIndex)) == 1;
    }

    public static int toggleBit(int bitIndex, int num) {
        return (num ^ (1 << bitIndex));
    }

    public static int removeLastSetBit(int n1) {
        // The 4+2+1 even odd bit set rule
        return (n1 & (n1 - 1));
    }

    public static boolean checkPowerOf2(int n1) {
        // Check the cases of overflow and 0 for bitwise operations
        return (n1 & (n1 - 1)) == 0;
    }

    public static int numberOfSetBits(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1); // checking if the last bit of the nums is '1'
            // dividing by 2 and discarding the bit
            num = num >> 1;
        }
        return count;
    }

    public static boolean isEven(int num) {
        return ((num & 1) == 0);
    }
}

// 1] Swap the numbers
// 2] set the ith bit to 1/0
// 3] Toggle the ith bit
// 4] Remove the ith Set Bit ==> Observing the relation between N and N-1
// 5] Check if the number is a power of two or not ?? ==> Only one set bit in
// the binary representation of a number
// 6] Number of Set bits ==> Purely based on a brute force approach ==> if
// remainder is 1 increase the count++; else conitnue dividng the number
// 7] Odd check and even check divided by two
// 8] Methods to check the set bits