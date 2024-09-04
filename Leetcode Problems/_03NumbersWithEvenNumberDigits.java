
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

// SOLUTION --> 
// METHOD 1 -->  NUMBER OF DIGITS IN A NUMBER ;
//int num=122435432;
// System.out.println(12/10);
// int digit=0;
// while(num!=0){
//     num=num/10;
//     digit++;

// }
// System.out.println(digit);

// METHOD 2 --> DIGIT%2==0 --> TRUE  -->  COUNT++

// ITERATING THROUGH WHOLE ARRAY
// for{for}

public class _03NumbersWithEvenNumberDigits {
    public static void main(String args[]) {
        int[] nums = { 555, 901, 482, 1771,34,3454,5465 };
        System.out.println(totalEvenDigitsNumber(nums));
    }

    static int totalEvenDigitsNumber(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int digit = 0;
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
