import java.util.Stack;
import java.util.HashMap;

public class Prefix {

    // Pass the the reversed string to the getPrefix function over here
    // Replace '(' with ')' and vice-versa

    public static StringBuilder generatePrefix(String s) {
        // Internally calling the private function so that we can pass the reverse
        // string
        StringBuilder sb = new StringBuilder(s);
        return getPrefix(sb.reverse());
    }

    private static StringBuilder getPrefix(StringBuilder s) {

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        HashMap<Character, Integer> hm = new HashMap<>();

        hm.put('^', 3);
        hm.put('*', 2);
        hm.put('/', 2);
        hm.put('+', 1);
        hm.put('-', 1);
        // Adding parenthesis only to identitfy easily that an incoming character is a
        // number digit
        hm.put('(', 0);
        hm.put(')', 0);

        int n = s.length();

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            // Skipping the Blank Spaces
            if (c == ' ')
                continue;

            // Else if it is a number ==> Multi Digit Support
            if (!hm.containsKey(c)) {
                // Read full number (could be multiple digits)
                StringBuilder num = new StringBuilder();
                while (i < n && !hm.containsKey(s.charAt(i)) && s.charAt(i) != ' ') {
                    num.append(s.charAt(i));
                    i++;
                }
                sb.append(num).append(" "); // add a space so numbers/operators are separated
                i--; // because for-loop will increment i
                continue;
            }

            if (c == ')') {
                st.push(c);
                continue;
            }

            // Parenthesis rule
            if (c == '(') {
                while (!st.isEmpty() && st.peek() != ')') {
                    sb.append(st.pop() + " ");
                }
                // discard the opening parenthesis
                st.pop();
                continue;
            }

            while (!st.isEmpty() && hm.get(st.peek()) >= hm.get(c)) {
                sb.append(st.pop() + " ");
            }

            st.push(c);

        }

        while (!st.isEmpty()) {
            sb.append(st.pop() + " ");
        }

        return sb.reverse();
    }

    public static double evaluatePrefix(StringBuilder s) {
        /*
         * Here if we have a prefix expression and wish to evaluate the same then we
         * just iterate through the last
         * part of the expression and keep on evaluation the same ==> Scanning the
         * prefix Expression From 'Right to Left'
         * and then performing s1 operation s2 ==> (s1 = st.pop()) and then (s2 =
         * st.pop())
         * 
         */

        Stack<Double> st = new Stack<>();
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        hm.put('^', 5);
        hm.put('*', 4);
        hm.put('/', 3);
        hm.put('+', 2);
        hm.put('-', 1);
        // Adding parenthesis only to identitfy easily that an incoming character is a
        // number digit
        hm.put('(', 0);
        hm.put(')', 0);

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            // Skipping the Blank Spaces
            if (c == ' ')
                continue;

            if (!hm.containsKey(c)) {
                // Read full number (could be multiple digits)
                StringBuilder num = new StringBuilder();
                while (i < n && !hm.containsKey(s.charAt(i)) && s.charAt(i) != ' ') {
                    num.append(s.charAt(i));
                    i++;
                }

                // Direclty addding the number to the stack;
                st.push(Double.parseDouble(num.toString()));
                i--; // because for-loop will increment i
                continue;
            } else {
                // Performing the operations using values added to the stack
                double op1 = st.pop();
                double op2 = st.pop();

                int k = hm.get(c);

                if (k == 5) {
                    st.push(Math.pow(op1, op2));
                } else if (k == 4) {
                    st.push(op1 * op2);
                } else if (k == 3) {
                    st.push(op1 / op2);
                } else if (k == 2) {
                    st.push(op1 + op2);
                } else {
                    st.push(op1 - op2);
                }
            }

        }

        return st.peek();

    }

    public static void main(String[] args) {
        // String s = "(A - B/ C) * (A / K - L)";
        String s = "-* + 2 2 3 10";
        System.out.println(evaluatePrefix(new StringBuilder(s)));
    }
}
