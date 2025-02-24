package Problems;

import java.util.Stack;

public class ValidParenthesis {
    static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (Character c : s.toCharArray()) {

            // Adding the opening parenthesis in the stack --> intially 
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            }

            // Chrcking for the existence of the closing brackets 

            if(c==']'){
                if(!st.isEmpty() || st.peek()==c){
                    st.pop();
                    
                }
            }

            if(c==')'){
                if(!st.isEmpty() || st.peek()==c){
                    st.pop();
                }
            }
            if(c=='}'){
                if(!st.isEmpty() || st.peek()==c){
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
