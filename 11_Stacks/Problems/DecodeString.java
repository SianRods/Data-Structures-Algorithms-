package Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {

        Stack<String> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('[');
        set.add(']');

        int n = s.length();
        int i = 0;
        for (; i < n; i++) {
            char c = s.charAt(i);

            if (!set.contains(c) && c < 'a' && c > 'z') {
                StringBuilder num = new StringBuilder();
                while (i < n && !set.contains(s.charAt(i)) && (s.charAt(i) < 'a' || s.charAt(i) > 'z')) {
                    num.append(s.charAt(i));
                    i++;
                }
                i--;// Decrementing i again to keep the flow of the outerloop in order
                s2.push(Integer.parseInt(num.toString()));
                continue;
            }

            else if (c == '[') {
                StringBuilder seq = new StringBuilder();
                i++;
                while (i < n && s.charAt(i) != ']') {
                    seq.append(s.charAt(i));
                    i++;
                }

                i--; // to keep the flow of the outer loop in the order
                s1.add(seq.toString());
            }

            else {
                break;
            }

        }

        StringBuilder result = new StringBuilder();
        while (!s1.isEmpty() && !s2.isEmpty()) {
            for (int k = 0; k < s2.pop(); k++) {
                result.append(s1.peek());
            }

            s1.pop();
        }

        // Attaching the remaining string

        while (i < n) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}