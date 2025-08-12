package Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {

        Stack<String> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;

        // Converting it to the char arrays is similar logic as using s.charAt(i);
        for (char c : s.toCharArray()) {
            // Check if it is a digit
            if (Character.isDigit(c)) {
                // keep on properly maintaing the number variable till '['before pushing in
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // Push the multi-digit number to the num stack
                s2.push(num);
                // push the current string into the stack
                s1.push(currStr.toString());
                num = 0;
                currStr = new StringBuilder();
            } else if (c == ']') {
                // Just the closing-square bracket
                // Start appending the previous string to the result variable
                String prev = s1.pop();
                int repeat = s2.pop();

                StringBuilder temp = new StringBuilder(prev);

                for (int i = 0; i < repeat; i++) {
                    temp.append(currStr);
                }

                currStr = temp;
            } else {
                // just appending the normal characters
                currStr.append(c);
            }

        }

        return currStr.toString();

    }
}