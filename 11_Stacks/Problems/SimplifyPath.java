package Problems;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {

    }

    static String simplifiedPath(String path) {
        Stack<String> st = new Stack<>();
        String arr[] = path.split("/");

        // Adding all the allowed files and path names into the stack
        for (String str : arr) {
            if(!str.equals("..") && !str.equals(".")&& !str.equals("")){
                // If the string is not equal to dots then push them into a stack
                st.push(str);
            }
            else{
                if(str.equals("..") && !st.isEmpty()){
                    // pop the previous element then 
                    st.pop();
                }
                if(str.equals(".")){
                    continue;
                }
            }
        }

        // returning into a compatible string format
        StringBuilder sb = new StringBuilder();
        // Iterating over the stack and adding forward slash to get them in to the original order
        for(String i : st){
            sb.append("/");
            sb.append(i);
        } 

        // If the String is Empty then return only the forward slash otherwise return the string 
        return sb.length()==0 ? "/" : sb.toString();

    }

}

// WRONG APPROACH BELOW where we unecessarily do the parsing of each and every
// character in the String

// static String simplifiedPath(String unixPath) {
// Stack<Character> st = new Stack<>();
// int countDots = 0;

// // Adding the Simplified Canonical Path to the Stack in Reversed Order
// for (Character c : unixPath.toCharArray()) {
// if (c == '/' && !st.empty()) {
// // Is the character is slash and the Stack is not empty --> Check for
// // duplication of the slash
// // initializing the countDots Variable to Zero
// countDots = 0;
// if (st.peek() == c) {
// continue;
// }
// }

// if (c == '.' && !st.isEmpty()) {
// // If the c=='.' and the stack is not empty check for the counter
// countDots++;
// if (countDots > 2) {
// if(countDots==3){
// // Adding the First Two Dots
// st.push('.');
// st.push('.');
// }
// st.push(c);
// }

// continue;
// }

// // Pushing all the remaining Characters into the stack
// countDots=0;
// st.push(c);
// }

// // ChECK IF THE TOP OF THE STACK IF SLASH
// if (st.peek() == '/') {
// st.pop();
// }

// return stackToString(st);
// }

// // Converting the Formated String into a Stack
// // Naive approach using a stack and stringbuilder to get the formatted String
// public static String stackToString(Stack<Character> stack) {
// if (stack == null || stack.isEmpty()) {
// return ""; // Handle empty stack case
// }

// StringBuilder sb = new StringBuilder();
// Stack<Character> tempStack = new Stack<>(); // Temporary stack to preserve
// original order

// // 1. Pop characters from the original stack and temporarily store them
// // (reversing order)
// while (!stack.isEmpty()) {
// tempStack.push(stack.pop());
// }

// // 2. Pop from the temp stack (now in correct order) and append to
// StringBuilder
// while (!tempStack.isEmpty()) {
// sb.append(tempStack.pop());
// }

// return sb.toString();
// }
// }

// -----------------------------------
// Sample TEST CASE 1 input : "/../" OUTPUT --> '/'