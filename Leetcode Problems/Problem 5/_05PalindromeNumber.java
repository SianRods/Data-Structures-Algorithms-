// LEETCODE PROBELME NUMBER - 09

// Given an integer x, return true if x is a 
// palindrome
// , and false otherwise.

// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
// Example 2:

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:

// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

// ---------------------------------------------------------------------------------------------------------------------
// APPROCH 1 :- 1.Basic Approach to Check the Number of Characters in the String and then return it 
// Considerations of all the edge cases is important for overall porblem solving ability
public class _05PalindromeNumber {
    public static void main(String argsp[]) {
        System.out.println(isPalin(1000021));
    }

    // TESST CASE FAILING WRONG SOLUTION
    static boolean isPalin(int num) {
        String sample = Integer.toString(num);
        boolean flag = false;
        // handling the boundary case when numbers are single digit sample.length()==1
        if(sample.length()==1){
            flag=true;
        }
        for (int i = 0; i < sample.length(); i++) {
            for (int j = (sample.length() - 1); j >= 0; j--) {
                if (sample.length() % 2 == 0) {
                    if (sample.charAt(i) == sample.charAt(j)) {
                        flag = true;
                    }else{
                        flag=false;
                    }
                } else {
                    if (i == (sample.length() / 2) || j == (sample.length()) / 2) {
                        continue;
                    } else {
                        if (sample.charAt(i) == sample.charAt(j)) {
                            flag = true;
                        }else{
                            flag=false;
                        }
                    }
                }
            }
        }
        return flag;
    }
}

// ----------------------------------------------------------------------------------------------------------------
// APPROACH 2 String can also be reversed and compared 
