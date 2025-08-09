package Problems;

import java.util.Stack;

public class RemoveKDigits {

    /*
     * This question appears to be very simple as it is but the level of difficulty
     * == Medium
     * this is due the Edge cases which are present in the question below
     * 1] The Idea of Monotonocity if true but what if all the elements in the
     * number are in
     * increasing order only so we wud end up removing nothing where as we can still
     * remove last k numbers
     * 
     * 2] The Second Edge case is handling the initial zeros in the numbers and
     * triming those off
     * 
     * 3] If K==N then we will end up popping out all of the chars in the numbers
     * and hence will have to
     * return '0' then
     * 
     */

    public String removeKdigits(String num, int k) {
        // The Idea is that the highest number should be at the last and the small
        // numbers should be at the
        // beginning

        // Note that as i have to reverse the element if i use stack afterwards i can
        // also use
        // List or dequeue for the same operation which require relatively less time to
        // learn

        Stack<Character> st = new Stack();
        int i;
        for (i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!st.isEmpty() && c - '0' < st.peek() - '0' && k > 0) {
                st.pop();
                k--;
            }
            st.push(c);

        }

        // In this case all the numbers in the string were alerady monotonic in nature
        while (k > 0) {
            st.pop();
        }

        if (st.isEmpty())
            return "0"; // In this case k==N and we have ended up popping all the elements

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }


        // There is a condition in the return statement because what if all the elements in the stack are zero
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
