// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=sliding-window
// Here we have to use the concept of Sliding Windows 
public class LongestSubstringNonRepeat {

    public static void main(String[] args) {
        String s = "abcabcbb";
        // String s = "bbbbb";
        // String s = "pwwkew";
        System.out.println("The Length of the Maximum Non-Repitative Substring : " + lengthOfLongestSubstring(s));
    }

    // @This Solution has a total runtime of 7ms and beats 36.92 %
    static int lengthOfLongestSubstring(String s) {
        int i = 0, j;
        int maxLength = 0;

        for (j = 0; j < s.length(); j++) {
            // if the substring from i to j inclusive consists of character j --> break
            // condition
            while (s.substring(i, j).indexOf(s.charAt(j)) != -1) {
                // Duplicate Sequence Present
                // Notice that here we are only updating the MAXL variable if we encounter any duplicates
                // But If there are no more duplicates till the end of the string, maxLength
                // won't be updated after the loop ends.
                // For example, if the string is "abcabcbb", your logic updates maxLength during
                // duplicates,
                // but if the longest unique substring is at the end, you will miss

                maxLength = Math.max(j - i, maxLength);
                i++;

            }

        }
        // Taking into account the last position of variable (i,j) after the loop ends
        // Here the position of j will be last but of i will matter and could be anywhere
        maxLength = Math.max(maxLength, j - i);
        return maxLength;
    }

    // @Figuring out more optimised solution --> using the internal functions of
    // string slows down the code
    static int optimizedSolution(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] lastIndex = new int[128];

        for (int start = 0, end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            start = Math.max(start, lastIndex[currentChar]);
            maxLength = Math.max(maxLength, end - start + 1);
            lastIndex[currentChar] = end + 1;
        }

        return maxLength;
    }

}
