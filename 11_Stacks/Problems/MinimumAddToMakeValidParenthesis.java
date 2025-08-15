package Problems;

import java.util.Stack;

public class MinimumAddToMakeValidParenthesis {
    // How do we actually minimize the moves for validating the parenthesis
    // Problem is clearly greedy

    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (!st.isEmpty() && st.peek() == '(' && c == ')') {
                open--;
            } else {
                close++;
            }

        }

        return open + close;
    }
}
