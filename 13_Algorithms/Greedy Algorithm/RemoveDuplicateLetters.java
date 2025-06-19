// Here we have to make sure that all the letters appears exactly one and only once 
// (char) ('a' + li.get(i))

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String args[]) {
        String s = "cbacdcbc";
        // removeDuplicateLetters(s);
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLettersWithoutOrderMaintain(String s) {
        ArrayList<Integer> li = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            li.add((int) (s.charAt(i) - 'a'));
        }

        Collections.sort(li);

        StringBuilder sb = new StringBuilder(" ");

        char lastChar = 0; // Placeholder for tracking the last appended character
        for (int i = 0; i < li.size(); i++) {
            char currentChar = (char) ('a' + li.get(i));
            if (sb.length() != 0 && currentChar == lastChar) {
                continue;
            } else {
                sb.append(currentChar);
                lastChar = currentChar;
            }
        }

        return sb.toString();
    }

    public static String removeDuplicateLetters(String s) {
        // Taking a note of frequency of all the characters
        int freq[] = new int[26];

        // Storing the Frequency of all the characters
        for (int i = 0; i < s.length(); ++i) {
           freq[(int) (s.charAt(i) - 'a')]++;
        }

        Stack<Character> st = new Stack<>();
        // Maintaing a boolean array to keep note if that given element has been visited
        // before or not
        boolean seen[] = new boolean[26];

        for (int i = 0; i < s.length(); ++i) {
            if (seen[(int) (s.charAt(i) - 'a')]) {
                // if true so we skip all the repititive occurences as we have to the character
                // is already
                // present in the stack
                freq[(int) (s.charAt(i) - 'a')]--;
                continue;
            }

            // For all the more prior elements we need to continue popping out from the
            // stack till we have empty stack
            // or we have a stack which follows the priority


            // The following statement in the below while loop : freq[(int)st.peek() - 'a'] > 0
            // Ensure that if a character is not going to appear again then we don't pop it out and let it stay in the stack only 
            //  even if it violates the condition
            while (!st.isEmpty() && st.peek() > s.charAt(i) && freq[(int)st.peek() - 'a'] > 0) {
                // first flag it as not seen as the successive occurences might be ignored if
                // not flagged
                // as false before
                seen[(int) (st.peek() - 'a')] = false;
                st.pop();
            }

            // Else we keep on adding the elements to the stack and decresing their
            // frequency
            st.push(s.charAt(i));
            freq[(int) (s.charAt(i) - 'a')]--;
            seen[(int) (s.charAt(i) - 'a')] = true;
        }

        StringBuilder sb = new StringBuilder("");

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();

    }

}