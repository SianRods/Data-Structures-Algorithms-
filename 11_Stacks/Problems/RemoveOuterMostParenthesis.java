
import java.util.*;

public class RemoveOuterMostParenthesis {

    public static void main(String[] args) {
        String s = "()(()())(())";

    }

    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int counter = 0; // if "(" +1 else -1

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // The Closing parenthesis check is done before cause we can
            if (c == ')') {
                counter--;
            }
           
            // We will only process the in between strings inside of the outer brackets 

            // We can only process the inner strings when the counter!0s ==> indication of processing 
            // an inner string
            
            if (counter != 0)
                sb.append(c);


            // The opening parenthesis check is done afterwards cause we can't include the outer
            // opening brackets in the inner expression
            if (c == '(') {
                counter++;
            }
        }

        return sb.toString();

    }
}
