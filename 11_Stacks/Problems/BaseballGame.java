package Problems;

import java.util.Stack;

public class BaseballGame {
    public static int calPoints(String[] operations) {
        // Clearly we can use a LIFO mechanism type data structure in order to store the
        // results
        // Which is highly intuitive as majority of the operations are on the last added
        // valid record

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                int n1 = st.pop();
                int n2 = st.pop();
                st.push(n1 + n2);
            } else if (operations[i].equals("C")) {
                st.pop();
            } else if (operations[i].equals("D")) {
                st.push(2 * st.peek());
            } else {
                st.add(Integer.parseInt(operations[i]));
            }
            System.out.println(st.peek());
        }

        int sol = 0;
        while (!st.isEmpty()) {
            sol += st.pop();
        }

        return sol;
    }

    public static void main(String[] args) {
        String arr[] = { "5", "2", "C", "D", "+" };
        System.out.println(calPoints(arr));
    }
}