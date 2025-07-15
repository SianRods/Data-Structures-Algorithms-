import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {

    }

    public static String largestNumber(int[] nums) {
        String strNums[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sorting the array based on the mathematical intuition of comparing their
        // relative placements
        // and not the actual individual value
        // This problem is specifically greedy because choosing locally optimal
        // placements for nearby numbers will
        // lead to formation of a larger number ex). "a"+"b"> "b"+"a" ???

        // Arrays.sort(strNums, (a, b) -> (a + b).compareTo(b + a));
        // The above code will sort in ascending order based on the concatenation.
        // But to form the largest number, you need to sort in descending order of the
        // combined string.

        // Importance of why we should sort using (b+a).compareTo(a+b);

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));




        // Edge cases where ==> if the highest number is "0", all are zero
        // Once sorted, we concatenate all the strings. If the first element in this sorted list is "0", it indicates that all 
        // numbers were zeros, so the largest number possible is "0". In this case, we return "0". If not, we return the concatenated result.
        if (strNums[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(strNums[i]);
        }

        return sb.toString();

    }
}
