import java.util.ArrayList;
import java.util.List;

public class SplitPrimeWise {

    public static void main(String[] args) {
        // int arr[] = { -1, 5, 7, 0 };
        int arr[] = { 175868717, 841457609, -948571070, -747264172 };

        System.out.println(splitArray(arr));
    }

    public static long splitArray(int[] nums) {
        // List<Integer> prime = new ArrayList<>();
        // List<Integer> notPrime=new ArrayList<>()
        long primeSum = 0;
        long notPrimeSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) {
                // prime.add(nums[i]);
                primeSum += nums[i];
            } else {
                notPrimeSum += nums[i];
            }
        }

        System.out.println(primeSum);
        System.out.println(notPrimeSum);
        return Math.abs(primeSum - notPrimeSum);
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;

        else if (n > 2) {
            long i = 2;
            while (i <= Math.sqrt(n)) {
                if (n % i == 0) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}