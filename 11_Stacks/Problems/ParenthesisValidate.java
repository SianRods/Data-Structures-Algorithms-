package Problems;

import java.util.Stack;

public class ParenthesisValidate {

    // In java Stack is slower relatively cause it is synchronized for the trheading
    // purposes

    public boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        int ast = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
            } else if (c == '*') {
                ast++;
            } else {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                    continue;
                } else if (ast > 0) {
                    ast--;
                    continue;
                }
            }
        }

        // Stack may still contain some opening brackets
        while (!st.isEmpty() && ast > 0) {
            st.pop();
            ast--;
        }

        return st.isEmpty();

    }
}
