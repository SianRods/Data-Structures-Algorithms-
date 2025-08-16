
import java.util.Stack;
// https://leetcode.com/problems/remove-duplicate-letters/description/ ==> same problem

public class SubsequenceOfDistinctCharacters {

    public static String smallestSubsequence(String s) {
        int freq[] = new int[26];
        boolean checkVisited[] = new boolean[26];
        // Counting all the unique characters
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // st.push(c);
            while (!st.isEmpty() && (int) st.peek() > (int) c && freq[st.peek() - 'a'] - 1 > 0
                    && !checkVisited[c - 'a']) {
                // Also updating the
                freq[st.peek() - 'a']--;
                checkVisited[st.pop() - 'a'] = false;
            }

            // Pushing iff the character has not been visited | that is not in the stack
            if (!checkVisited[c - 'a']) {
                st.push(c);
                checkVisited[c - 'a'] = true;
            }

        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        // String s = "bcabc";
        String s = "cbacdcbc";
        System.out.println(smallestSubsequence(s));
    }

}
