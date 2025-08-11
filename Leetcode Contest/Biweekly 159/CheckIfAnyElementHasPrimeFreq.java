import java.util.Hashtable;

public class CheckIfAnyElementHasPrimeFreq {

    public static void main(String[] args) {

    }

    public static boolean checkPrimeFrequency(int[] nums) {
        // Adding all the elements of the array to the hashtable
        Hashtable<Integer, Integer> hm = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.get(nums[i]) != null) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                // Add a new occurence
                hm.put(nums[i], 1);
            }
        }

        for (Integer key : hm.keySet()) {
            if (checkIfPrime(hm.get(key))) {
                return true;
            }
        }

        return false;

    }

    public static boolean checkIfPrime(int num) {
        // Check if the Number if prime
        if (num < 2)
            return false;
        if (num == 3)
            return true;

        int i = (int) Math.sqrt(num);
        while (i > 1) {
            if (num % i == 0) {
                return false;
            }
            i--;
        }

        return true;

    }

}
