//  66.PlusOne 
// You are given a large integer represented as an integer array digits,
//  where each digits[i] is the ith digit of the integer. 
//  The digits are ordered from most significant to least significant in left-to-right order. 
//  The large integer does not contain any leading 0's.




import java.math.BigInteger;
import java.util.Arrays;

public class PlusOneStringApproach {
    public static void main(String[] args) {
        int arr[] = { 9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(incrementArray(arr)));
    }

    // Extra memory space for solution array will be required as we may require some
    // extra space

    static int[] incrementArray(int arr[]) {
        // Convert the Array into a String then convert it into an Integer
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(Integer.toString(arr[i]));
        }
        // System.out.println(builder); 9999
        // Stringbuilder-->String-->Integer anmd incrementing it
        BigInteger num = new BigInteger(builder.toString());
        num = num.add(BigInteger.ONE);
        String solutionString = num.toString();
        int sol[] = new int[solutionString.length()];
        System.out.println(Arrays.toString(sol));
        for (int j = 0; j < sol.length; j++) {
            sol[j] = Character.getNumericValue(solutionString.charAt(j));

        }

        return sol;
    }
}
