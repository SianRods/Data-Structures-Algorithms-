package Problems;

import java.util.Stack;

public class ValidStackSequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        // My Approach was correct but it was implemented in a little bit reverse order
        // Maintaing an empty stack and keep and maintain two pointers at the the start
        // of both the arrays
        // always in the array first we will initiate the push operation
        // while(i<n && a[i]==a[j])st.pop() j++;
        // similary we will iterate over all the elements of the pushed array

        int i = 0;
        Stack<Integer> st = new Stack<>();
        int n = pushed.length;
        for (int num : pushed) {
            st.push(num);
            while (!st.isEmpty() && i < n && st.peek() == popped[i]) {
                st.pop();
                i++;
            }
        }

        return st.empty();

    }

}
