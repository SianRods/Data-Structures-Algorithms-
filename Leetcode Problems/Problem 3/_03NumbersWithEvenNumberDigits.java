
// Problem Number 1295 Leetcode
// Given an array nums of integers, return how many of them contain an even number of digits.
// Example 1:

// Input: nums = [12,345,2,6,7896]
// Output: 2
// Explanation: 
// 12 contains 2 digits (even number of digits). 
// 345 contains 3 digits (odd number of digits). 
// 2 contains 1 digit (odd number of digits). 
// 6 contains 1 digit (odd number of digits). 
// 7896 contains 4 digits (even number of digits). 
// Therefore only 12 and 7896 contain an even number of digits.
// Example 2:

// Input: nums = [555,901,482,1771]
// Output: 1 
// Explanation: 
// Only 1771 contains an even number of digits.

// Constraints:

// 1 <= nums.length <= 500
// 1 <= nums[i] <= 105
// ---------------------------------------------------------------------------------------------------------------------
// Note that to count the length of the Number Different apporaches can be used 
// 1] Count The digits 
// 2] Convert the int to String and check the length of the string 
// 3] If we consider Neagtive numbers num!=0 is a good case not num>0
// 4] Possible also include condition for 0 which is 1 Digit number

// ------------------------------------------------------------------------------------------------------------------

// Approach-1 Part 1-->
// The below solution beasts almost 25 percent of the solutions 

public class _03NumbersWithEvenNumberDigits {
    public static void main(String args[]) {
        int[] nums = { 555, 901, 482, 1771,34,3454,5465,-1234,00 };
        System.out.println(totalEvenDigitsNumber(nums));
    }

    static int totalEvenDigitsNumber(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int digit = 0;
            // if condition num>0 --> it would only work for postive numbers 
            while (arr[i] != 0) {
                arr[i] = arr[i]/10;
                digit++;
            }
            if (digit%2 == 0) {
                count++;
            }
        }
        return count;

    }

}

