
/*
 * There are basiaclly three rules which are very very important in order to
 * evaluate any expression
 * 
 * 1] Precedence Rule ==> can be implemented using a hashmap
 * 2] Associativity Rule ==> can be implemented using a hashmap
 * 3] Parenthesis -Priority Rule ==> implemented using the stack itself
 * 
 * Rules for Evaluation of the expression infix ==> prefix
 * Note that here the string may also contain random spaces
 * 
 * A] Scan the expression from left to right
 * 
 * B] If Operator arrives and stack is empty or contains ( then push this
 * operator onto the stack.
 * 
 * C] If incoming operator has HIGHER precedence than TOP of the stack then PUSH
 * this operator onto the stack
 * 
 * D] If incoming operator has LOWER or EQUAL precedence than TOP of the stack
 * then POP this operator in print in POSTFIX array. Then test the precedence of
 * incoming operator with NEW TOP of the stack
 * 
 * E] IF a ( is encountered, push it on the stack
 * 
 * F] IF a ) is encountered, then
 * 1] Repeatedly pop from stack and add it to the postfix expression until a (
 * is encountered.
 * 2] Discard the (
 * 
 * G] At the end of expression, POP and print all element of stack in postfix
 * array. 
 * 
 * H] for rigth Associative operators we only pop iff the incoming operator has
 * the lower precedence else we dont'
 * 
 * 
 * Formatting Rules for the Expression output  =>
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
import java.util.HashMap;
import java.util.Stack;

public class Prefix {

    // public static int calculate(String s) {

    // }

    public static StringBuilder getPostFix(String s) {
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

            // Correct Handling of opening brackets
            // Even though the opening bracket is in the hashmap whenever we use ( with
            // precendecen value
            // Edge case '(' == st.peek() and '(' ==> incoming element == Wrong Operations
            // Hence we are explicitly handling opening brackets
            if (c == '(') {
                st.push(c);
                continue;
            }

            // Parenthesis rule
            if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
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

        return sb;

    }

    // Test the functions
    public static void main(String[] args) {
        // String s = " A + B * C - D / E";
        // String s = "( a + b - c ) * d - ( e + f ) ";
        String s = "( 42 + 35) * 53 / 6";
        System.out.println(getPostFix(s));
    }

}
